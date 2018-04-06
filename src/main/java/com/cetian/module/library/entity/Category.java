/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Category.java 
 * @date 2018年3月30日 下午5:39:51 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  Category   
 * @Description: 题目分类
 * @date:  2018年3月30日 下午5:39:51
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_category")
public class Category extends IdEntity{
	private String name;
	private String remark;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
