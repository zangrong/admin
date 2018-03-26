/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AdminRole.java 
 * @date 2018年3月25日 下午5:17:35 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  AdminRole   
 * @Description: 管理员角色管理表
 * @date:  2018年3月25日 下午5:17:35
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_sys_admin_role")
public class AdminRole extends IdEntity{
	private Long adminId;
	private Long roleId;
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
