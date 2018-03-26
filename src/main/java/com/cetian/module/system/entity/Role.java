/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Role.java 
 * @date 2018年3月5日 下午4:43:03 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  Role   
 * @Description:TODO
 * @date:  2018年3月5日 下午4:43:03
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_sys_role")
public class Role extends IdEntity{
	
	public static final String ROLE_SUPER = "super";

	private String name;// 角色名
	private String value;// 随机字符串作为角色值，目前考虑是super,admin
	private String remark;// 备注信息
	@Transient
	private Set<String> permissions = new HashSet<>();// 权限点集合，瞬时属性
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Set<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}
	// 判断 role 是否包含指定的权限 permissionValue
	public boolean hasPermission(String permissionValue) {
		if (permissionValue == null) {
			return true;
		}
		if (CollectionUtils.isEmpty(permissions)) {
			return false;
		}
		return permissions.contains(permissionValue);
	}
	
}
