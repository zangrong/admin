/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: QuestionTypeEnum.java 
 * @date 2018年3月29日 上午9:46:29 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName:  QuestionTypeEnum   
 * @Description:TODO
 * @date:  2018年3月29日 上午9:46:29
 * @author: zangrong
 * 
 */
public enum QuestionTypeEnum {
	single(0), // 单选
	multiple(1),// 多选
	truefalse(2),// 是非题
	blank(3),// 填空题
	shortanswer(4),// 简单题
	essay(5),// 论述题
	;

	private int value;

	private QuestionTypeEnum(int value) { // 必须是private的，否则编译错误
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
