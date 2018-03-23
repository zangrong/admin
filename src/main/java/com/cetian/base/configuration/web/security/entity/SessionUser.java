/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: SessionUser.java 
 * @date 2018年3月16日 下午3:15:37 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName:  SessionUser   
 * @Description: 存放在session中的user对象，不持久化
 * @date:  2018年3月16日 下午3:15:37
 * @author: zangrong
 * 
 */
public class SessionUser {
	public static final String SESSION_USER_KEY = "session_user";
	
	private Long id;
	private String head;// 头像
	private String path;// 默认访问路径
	private String name;// 用户名
	private String username;// 登录名
	private List<SessionModule> modules = new ArrayList<>();
	private Set<String> roles;// 角色集合
	private Set<String> permissions = new HashSet<>();// 权限集合
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<SessionModule> getModules() {
		return modules;
	}
	public void setModules(List<SessionModule> modules) {
		this.modules = modules;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public Set<String> getPermissions() {
		return permissions;
	}
	public void addPermissions(Collection<String> permissions) {
		this.permissions.addAll(permissions);
	}
	
}
