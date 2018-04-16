/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ContentSourceTypeEnum.java 
 * @date 2018年4月13日 下午4:45:51 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName:  ContentSourceTypeEnum   
 * @Description: 内容来源类型
 * @date:  2018年4月13日 下午4:45:51
 * @author: zangrong
 * 
 */
public enum ContentSourceTypeEnum {
	original(0), //原创
	reprint(1), // 转载
	contribute(2), // 投稿
	;

	private int value;

	private ContentSourceTypeEnum(int value) { // 必须是private的，否则编译错误
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
