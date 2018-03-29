/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Admin.java 
 * @date 2018年2月28日 下午1:56:57 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private String name;// 用户名
	private String username;// 登录名
	private String password;// 密码，密文
	@Enumerated(EnumType.ORDINAL)
	private AdminStatusEnum status;// 状态
	private Date createDate;// 创建时间
	private Date updateDate;// 更新时间
	
	@Transient
	private List<Role> roles;
	
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public AdminStatusEnum getStatus() {
		return status;
	}

	public void setStatus(AdminStatusEnum status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
