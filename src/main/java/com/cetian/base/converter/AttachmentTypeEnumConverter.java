/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AttachmentTypeEnumConverter.java 
 * @date 2018年4月13日 下午4:17:43 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cetian.module.common.entity.AttachmentTypeEnum;

/**
 * @ClassName:  AttachmentTypeEnumConverter   
 * @Description:TODO
 * @date:  2018年4月13日 下午4:17:43
 * @author: zangrong
 * 
 */
@Component
public class AttachmentTypeEnumConverter implements Converter<String, AttachmentTypeEnum> {

	@Override
	public AttachmentTypeEnum convert(String source) {
		AttachmentTypeEnum en = null;
		switch (source) {
		case "1":
			en = AttachmentTypeEnum.image;
			break;
		case "2":
			en = AttachmentTypeEnum.video;
			break;
		case "3":
			en = AttachmentTypeEnum.audio;
			break;
		case "0":
			en = AttachmentTypeEnum.file;
			break;
		}
		return en;
	}

}
