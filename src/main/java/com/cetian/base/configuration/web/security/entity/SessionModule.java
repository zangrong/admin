/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: SessionModule.java 
 * @date 2018年3月16日 下午3:17:13 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web.security.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ClassName:  SessionModule   
 * @Description:TODO
 * @date:  2018年3月16日 下午3:17:13
 * @author: zangrong
 * 
 */
public class SessionModule {
	private Long id;
	private String name;
	private String logo;// 模块名称前面的标识
	private boolean active;// 是否处于激活状态
	private SessionModule parent;// 父模块
	private String value;
	private String path;
	private Set<String> permissions = new HashSet<>();// permissionValue
	private List<SessionModule> children;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@JsonIgnore
	public SessionModule getParent() {
		return parent;
	}
	public void setParent(SessionModule parent) {
		this.parent = parent;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Set<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}
	public List<SessionModule> getChildren() {
		return children;
	}
	public void setChildren(List<SessionModule> children) {
		this.children = children;
	}
	public void addPermission(String permissionValue) {
		permissions.add(permissionValue);
	}
	public void addPermissions(Set<String> permissionValues) {
		permissions.addAll(permissionValues);
	}
	// 是否是最底一层模块
	@JsonIgnore
	public boolean isLeaf() {
		return CollectionUtils.isEmpty(this.children);
	}
}
