/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: RolePermission.java 
 * @date 2018年3月25日 下午5:16:27 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  RolePermission   
 * @Description:TODO
 * @date:  2018年3月25日 下午5:16:27
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_sys_role_permission")
public class RolePermission extends IdEntity{
	private Long roleId;
	private Long permissionId;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
}
