/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ContentStatusEnum.java 
 * @date 2018年4月6日 下午7:45:05 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName:  ContentStatusEnum   
 * @Description:TODO
 * @date:  2018年4月6日 下午7:45:05
 * @author: zangrong
 * 
 */
public enum ContentStatusEnum {
	visible(0), // 正常可见
	hide(1), // 隐藏
	deleted(2),// 删除
	;

	private int value;

	private ContentStatusEnum(int value) { // 必须是private的，否则编译错误
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
