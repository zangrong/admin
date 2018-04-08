/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AdminDetailsService.java 
 * @date 2018年3月2日 上午9:03:55 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cetian.base.configuration.web.security.entity.SessionModule;
import com.cetian.base.configuration.web.security.entity.SessionUser;
import com.cetian.module.admin.dao.AdminDao;
import com.cetian.module.admin.entity.Admin;
import com.cetian.module.system.cache.ModuleCache;
import com.cetian.module.system.dao.PermissionDao;
import com.cetian.module.system.dao.RoleDao;
import com.cetian.module.system.entity.Permission;
import com.cetian.module.system.entity.Role;
import com.cetian.module.system.service.PermissionService;

/**
 * @ClassName:  CtUserDetailsService   
 * @Description:TODO
 * @date:  2018年3月2日 上午9:03:55
 * @author: zangrong
 * 
 */
public class CtUserDetailsService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(CtUserDetailsService.class);
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private ModuleCache moduleCache;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Admin admin = adminDao.findByUsername(username);
		if (admin == null) {
			log.warn("用户不存在[{}]", username);
			throw new UsernameNotFoundException("User not found.");
		}
		
		UserBuilder builder = User.withUsername(username);
		builder.password(admin.getPassword());
		Set<String> roles = roleDao.findValueByAdminId(admin.getId());
		builder.roles(roles.toArray(new String[] {}));
		
		return builder.build();
	}
	
	/**
	 * @Title: createSessionUser   
	 * @Description: 在session里创建一个user对象，方便程序调用
	 * @return: SessionUser      
	 * @throws:
	 */
	public SessionUser createSessionUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails principal = (UserDetails) authentication.getPrincipal();
		Admin admin = adminDao.findByUsername(principal.getUsername());
		
		SessionUser user = new SessionUser();
		user.setId(admin.getId());
		user.setUsername(admin.getUsername());
		user.setName(admin.getName());
		user.setHead(admin.getHead());
		Set<String> roleSet = roleDao.findValueByAdminId(admin.getId());
		user.setRoles(roleSet);
		if (roleSet.contains(Role.ROLE_SUPER)) {
			// 超管就获取所有权限
			Set<String> permissionSet = permissionDao.findAllValue();
			user.setPermissions(permissionSet);
		}else {
			Set<String> permissionSet = permissionDao.findValueByAdminId(admin.getId());
			user.setPermissions(permissionSet);
		}
		
		// 从缓存中获取 module 列表
		List<SessionModule> sessionModules = moduleCache.get();
		
		Map<String, Permission> permissionMap = permissionService.getKeyMap();
		
		// 过滤出该用户有权限的 module 列表
		recruitCheck(user, sessionModules, permissionMap);
		// 设置该 module 列表到user
		user.setModules(sessionModules);
		return user;
	}
	
	/**
	 * @Title: recruitCheck   
	 * @Description: 递归匹配检查，用户具备哪些模块的权限
	 * @param user
	 * @param sessionModules      
	 * @param permissionMap 
	 * @return: void      
	 * @throws:
	 */
	private void recruitCheck(SessionUser user, List<SessionModule> sessionModules, Map<String, Permission> permissionMap) {
		if (CollectionUtils.isEmpty(sessionModules)) {
			return;
		}
		List<SessionModule> removeList = new ArrayList<>();
		for (SessionModule sessionModule : sessionModules) {
			// 如果 user 和 sessionModule 的 permissions 的交集为空，表示 user 没有该 sessionModule 权限
			if (!CollectionUtils.containsAny(sessionModule.getPermissions(), user.getPermissions())) {
				removeList.add(sessionModule);
				sessionModule.setParent(null);
			}else {
				List<SessionModule> children = sessionModule.getChildren();
				if (CollectionUtils.isEmpty(children)) {
					// 如果子模块为空，就要确定访问路径 path
					// 根据user 在该模块下的权限，找出可以访问的路径
					@SuppressWarnings("unchecked")
					Collection<String> intersection = CollectionUtils.intersection(user.getPermissions(), sessionModule.getPermissions());
					for (String perValue : intersection) {
						Permission permission = permissionMap.get(perValue);
						if (permission != null && StringUtils.isNotBlank(permission.getPath())) {
							sessionModule.setPath(permission.getPath());
							break;
						}
					}
					if (StringUtils.isBlank(sessionModule.getPath())) {
						log.warn("sessionModule[{},{}] 未找到匹配的 path", sessionModule.getId(), sessionModule.getName());
					}
				}else {
					// 递归检查是否有子模块权限
					recruitCheck(user, children, permissionMap);
				}
			}
		}
		// 移除没有权限的模块集合
		if (CollectionUtils.isNotEmpty(removeList)) {
			sessionModules.removeAll(removeList);
		}
	}

}
