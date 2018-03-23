/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ModuleCache.java 
 * @date 2018年3月19日 上午10:47:21 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.cache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.cetian.base.cache.BaseCache;
import com.cetian.base.configuration.web.security.entity.SessionModule;
import com.cetian.module.system.dao.ModuleDao;
import com.cetian.module.system.dao.PermissionDao;
import com.cetian.module.system.entity.Module;
import com.cetian.module.system.entity.Permission;

/**
 * @ClassName:  ModuleCache   
 * @Description:TODO
 * @date:  2018年3月19日 上午10:47:21
 * @author: zangrong
 * 
 */
@Service
public class ModuleCache extends BaseCache{
	
	private static final Logger log = LoggerFactory.getLogger(ModuleCache.class);
	
	public static final String SESSION_MODULE_LIST = "session_module_list";
	
	@Autowired
	private ModuleDao moduleDao;
	@Autowired
	private PermissionDao permissionDao;
	
	private RedisTemplate<Object, Object> cache() {
		return redis1_0;
	}
	
	@PostConstruct
	public void init() {
		// 启动时刷新 sessionModules 缓存
		List<Module> modules = moduleDao.findTopLevelOrderBySort();
		Iterable<Permission> permissions = permissionDao.findAll();
		List<SessionModule> sessionModules = recruitProcess(null, modules, permissions);
		save(sessionModules);
	}
	
	/**
	 * @Title: get   
	 * @Description: 获取缓存的 sessionModules
  	 * @return: List<SessionModule>      
	 * @throws:
	 */
	@SuppressWarnings("unchecked")
	public List<SessionModule> get(){
		List<SessionModule> sessionModules = (List<SessionModule>) cache().opsForValue().get(SESSION_MODULE_LIST);
		if (sessionModules == null) {
			List<Module> modules = moduleDao.findTopLevelOrderBySort();
			Iterable<Permission> permissions = permissionDao.findAll();
			sessionModules = recruitProcess(null, modules, permissions);
			save(sessionModules);
		}
		return sessionModules;
	}
	
	private void save(List<SessionModule> sessionModules) {
		cache().opsForValue().set(SESSION_MODULE_LIST, sessionModules);
	}
	
	/**
	 * @Title: update   
	 * @Description: 刷新缓存，一旦权限数据变更，需要刷新该缓存 
	 * @return: void      
	 * @throws:
	 */
	public void update() {
		List<SessionModule> sessionModules = get();
		save(sessionModules);
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
	private List<SessionModule> recruitProcess(SessionModule parent, List<Module> modules, Iterable<Permission> permissions) {
		List<SessionModule> sessionModules = new ArrayList<>();
		for (Module module : modules) {
			SessionModule sessionModule = convert(module);
			if (sessionModule == null) {
				continue;
			}
			long id = sessionModule.getId();
			// 设置父模块
			sessionModule.setParent(parent);
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
				List<SessionModule> sessionModuleChildren = recruitProcess(sessionModule, children, permissions);
				sessionModule.setChildren(sessionModuleChildren);
			}
			// 把子模块的权限也添加到父模块上
			if (parent != null) {
				parent.addPermissions(sessionModule.getPermissions());
			}
			sessionModules.add(sessionModule);
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
		sessionModule.setLogo(module.getLogo());
		sessionModule.setName(module.getName());
		sessionModule.setValue(module.getValue());
		return sessionModule;
	}
	
}
