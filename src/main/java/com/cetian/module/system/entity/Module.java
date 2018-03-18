/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: Module.java 
 * @date 2018年3月13日 下午3:30:49 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  Module   
 * @Description:TODO
 * @date:  2018年3月13日 下午3:30:49
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_sys_module")
public class Module extends IdEntity{
	private String name; // 中文显示名
	private String value;// 英文key值，key在sql里是关键字
	private Integer sort;// 可以手动排序，默认0
	private Boolean enabled;// 是否启用，默认启用
	
	// 实现树形结构
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id")
	private Module parent;
	@OrderBy(value = "sort asc")
	@OneToMany(mappedBy = "parent", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Module> children;
	
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
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Module getParent() {
		return parent;
	}
	public void setParent(Module parent) {
		this.parent = parent;
	}
	public List<Module> getChildren() {
		return children;
	}
	public void setChildren(List<Module> children) {
		this.children = children;
	}
	
}
