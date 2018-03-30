/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AttachmentTypeEnum.java 
 * @date 2018年3月29日 上午10:16:35 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName:  AttachmentTypeEnum   
 * @Description: 附件类型
 * @date:  2018年3月29日 上午10:16:35
 * @author: zangrong
 * 
 */
public enum AttachmentTypeEnum {
	image(0), // 图片
	audio(1),// 音频
	video(2),// 视频
	file(3),// 文件
	;

	private int value;

	private AttachmentTypeEnum(int value) { // 必须是private的，否则编译错误
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
