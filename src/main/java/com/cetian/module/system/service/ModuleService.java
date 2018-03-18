/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: ModuleService.java 
 * @date 2018年3月14日 下午4:58:17 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.base.configuration.web.security.entity.SessionModule;
import com.cetian.base.configuration.web.security.entity.SessionUser;
import com.cetian.module.system.dao.ModuleDao;
import com.cetian.module.system.dao.PermissionDao;
import com.cetian.module.system.entity.Module;
import com.cetian.module.system.entity.Permission;

/**
 * @ClassName:  ModuleService   
 * @Description:TODO
 * @date:  2018年3月14日 下午4:58:17
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class ModuleService {
	
	private static final Logger log = LoggerFactory.getLogger(ModuleService.class);
	
	@Autowired
	private ModuleDao moduleDao;
	@Autowired
	private PermissionDao permissionDao;
	
	public void setSessionModuleList(SessionUser user){
		List<Module> modules = moduleDao.findTopLevelOrderBySort();
		Iterable<Permission> permissions = permissionDao.findAll();
		List<SessionModule> sessionModules = recruitProcess(null, modules, user, permissions);
		user.setModules(sessionModules);;
	}
	
	/**
	 * @Title: recruitProcess   
	 * @Description: 递归处理sessionModule
	 * @param parent
	 * @param modules
	 * @param user 
	 * @param permissions 
	 * @return: List<SessionModule>      
	 * @throws:
	 */
	private List<SessionModule> recruitProcess(SessionModule parent, List<Module> modules, SessionUser user, Iterable<Permission> permissions) {
		List<SessionModule> sessionModules = new ArrayList<>();
		for (Module module : modules) {
			SessionModule sessionModule = convert(module);
			if (sessionModule == null) {
				continue;
			}
			long id = sessionModule.getId();
			// 获取该模块的直接权限
			for (Permission permission : permissions) {
				if (id == permission.getModuleId()) {
					sessionModule.addPermission(permission.getValue());
				}
			}
			// 递归处理子模块
			List<Module> children = module.getChildren();
			if (CollectionUtils.isEmpty(children)) {
				// 如果子模块为空，就要确定访问路径 path
				for (Permission permission : permissions) {
					if (StringUtils.isNotBlank(permission.getPath())) {
						sessionModule.setPath(permission.getPath());
						break;
					}
				}
				if (StringUtils.isBlank(sessionModule.getPath())) {
					log.warn("sessionModule[{},{}] 未找到匹配的 path", sessionModule.getId(), sessionModule.getName());
				}
			}else {
				// 如果子模块不为空，就要递归处理
				List<SessionModule> sessionModuleChildren = recruitProcess(sessionModule, children, user, permissions);
				sessionModule.setChildren(sessionModuleChildren);
			}
			// 把子模块的权限也添加到父模块上
			if (parent != null) {
				parent.addPermissions(sessionModule.getPermissions());
			}
			// 如果权限有交集，就表示用户有该模块交集
			if (CollectionUtils.containsAny(user.getPermissions(), sessionModule.getPermissions())) {
				sessionModules.add(sessionModule);
			}
		}
		return sessionModules;
	}
	
	private SessionModule convert(Module module) {
		// 考虑enabled问题
		if (module.getEnabled() == false) {
			return null;
		}
		SessionModule sessionModule = new SessionModule();
		sessionModule.setId(module.getId());
		sessionModule.setName(module.getName());
		sessionModule.setValue(module.getValue());
		return sessionModule;
	}
	
}
