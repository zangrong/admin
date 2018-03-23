/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Permission.java 
 * @date 2018年3月13日 下午3:24:29 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  Permission   
 * @Description: 权限点
 * @date:  2018年3月13日 下午3:24:29
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_sys_permission")
public class Permission extends IdEntity{
	private String name;// 中文名称
	private String value;// 英文值
	private String path;// 权限控制的访问路径
	private String remark;// 备注，如果有的话
	private Long moduleId;// 所属模块id
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getModuleId() {
		return moduleId;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	
}
