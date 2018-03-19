/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
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

import org.apache.commons.lang3.StringUtils;

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

	private String name;// 角色名
	private String value;// 随机字符串作为角色值，目前考虑是uuid
	private String remark;// 备注信息
	private String permissions;// 所包含的permission，用英文逗号(,)隔开
	@Transient
	private Set<String> permissionSet = new HashSet<>();// 权限点集合，瞬时属性
	
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
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public Set<String> getPermissionSet() {
		// 把权限点添加到集合中
		this.permissionSet.clear();
		if (StringUtils.isNotBlank(this.permissions)) {
			String[] split = StringUtils.split(permissions, ",");
			for (String per : split) {
				this.permissionSet.add(per);
			}
		}
		return permissionSet;
	}
	// 判断 role 是否包含指定的权限 permissionValue
	public boolean hasPermission(String permissionValue) {
		return permissionSet.contains(permissionValue);
	}
	
}
