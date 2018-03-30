/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: QuestionStatusEnum.java 
 * @date 2018年3月29日 下午1:56:20 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName:  QuestionStatusEnum   
 * @Description:TODO
 * @date:  2018年3月29日 下午1:56:20
 * @author: zangrong
 * 
 */
public enum QuestionStatusEnum {
	valid(0), // 合法
	invalid(2),// 非法
	;

	private int value;

	private QuestionStatusEnum(int value) { // 必须是private的，否则编译错误
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
