/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Setting.java 
 * @date 2018年3月25日 下午3:20:14 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  Setting   
 * @Description:TODO
 * @date:  2018年3月25日 下午3:20:14
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_sys_setting")
public class Setting extends IdEntity{
	private String name;
	private String value;
	private String remark;
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
	
}
