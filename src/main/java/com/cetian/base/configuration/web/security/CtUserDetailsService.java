/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: AdminDetailsService.java 
 * @date 2018年3月2日 上午9:03:55 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web.security;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.cetian.base.configuration.web.security.entity.SessionUser;
import com.cetian.module.admin.dao.AdminDao;
import com.cetian.module.admin.entity.Admin;
import com.cetian.module.system.dao.RoleDao;
import com.cetian.module.system.entity.Role;
import com.cetian.module.system.service.ModuleService;

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
	private ModuleService moduleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Admin admin = adminDao.findByUsername(username);
		if (admin == null) {
			log.warn("用户不存在[{}]", username);
			throw new UsernameNotFoundException("User not found.");
		}
		
		UserBuilder builder = User.withUsername(username);
		builder.password(admin.getPassword());
		builder.roles(StringUtils.split(admin.getRoles(), ","));
		
		return builder.build();
	}
	
	/**
	 * @Title: createSessionUser   
	 * @Description: 在session里创建一个user对象，方便程序调用
	 * @param session      
	 * @return: void      
	 * @throws:
	 */
	public void createSessionUser(HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Admin admin = adminDao.findByUsername(authentication.getPrincipal().toString());
		SessionUser user = new SessionUser();
		user.setRoles(admin.getRoleSet());
		List<Role> roles = roleDao.findByValueIn(admin.getRoleSet());
		for (Role role : roles) {
			user.addPermissions(role.getPermissionSet());
		}
		moduleService.setSessionModuleList(user);
	}

}
