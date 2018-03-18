/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: Admin.java 
 * @date 2018年2月28日 下午1:56:57 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.cetian.base.entity.IdEntity;
import com.cetian.module.system.entity.Role;

/**
 * @ClassName: Admin
 * @Description: 管理员用户
 * @date: 2018年2月28日 下午1:56:57
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_sys_admin")
public class Admin extends IdEntity {

	private String head;// 头像
	private String name;// 昵称
	private String username;// 登录名
	private String password;// 密码，密文
	@Enumerated(EnumType.ORDINAL)
	private AdminStatusEnum status;// 状态
	private String roles;// 角色key值
	private Date createDate;// 创建时间
	
	@Transient
	private Set<String> roleSet = new HashSet<>();
	@Transient
	private List<Role> roleList;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
		// 把权限点添加到集合中
		if (StringUtils.isNotBlank(roles)) {
			this.roleSet.clear();
			String[] split = StringUtils.split(roles, ",");
			for (String roleValue : split) {
				this.roleSet.add(roleValue);
			}
		}
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public AdminStatusEnum getStatus() {
		return status;
	}

	public void setStatus(AdminStatusEnum status) {
		this.status = status;
	}

	public Set<String> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<String> roleSet) {
		this.roleSet = roleSet;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	

}
