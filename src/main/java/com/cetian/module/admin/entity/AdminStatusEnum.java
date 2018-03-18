/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: AdminStatusEnum.java 
 * @date 2018年3月5日 下午4:45:25 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName:  AdminStatusEnum   
 * @Description: 管理员状态
 * @date:  2018年3月5日 下午4:45:25
 * @author: zangrong
 * 
 */
public enum AdminStatusEnum {
	
	inactive(0), // 禁用
	active(1), // 正常
	;

	private int value;

	private AdminStatusEnum(int value) { // 必须是private的，否则编译错误
		this.value = value;
	}

	@JsonValue
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
