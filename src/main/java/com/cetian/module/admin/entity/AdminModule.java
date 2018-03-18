/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: AdminModule.java 
 * @date 2018年3月18日 下午12:00:44 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.entity;

/**
 * @ClassName:  AdminModule   
 * @Description:TODO
 * @date:  2018年3月18日 下午12:00:44
 * @author: zangrong
 * 
 */
public class AdminModule {
	private Long adminId;
	private Long moduleName;
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public Long getModuleName() {
		return moduleName;
	}
	public void setModuleName(Long moduleName) {
		this.moduleName = moduleName;
	}
	
}
