/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: QuestionTypeEnumConverter.java 
 * @date 2018年3月30日 上午11:35:38 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cetian.module.library.entity.QuestionTypeEnum;

/**
 * @ClassName:  QuestionTypeEnumConverter   
 * @Description:TODO
 * @date:  2018年3月30日 上午11:35:38
 * @author: zangrong
 * 
 */
@Component
public class QuestionTypeEnumConverter implements Converter<String, QuestionTypeEnum> {

	@Override
	public QuestionTypeEnum convert(String source) {
		QuestionTypeEnum en = null;
		switch (source) {
		case "0":
			en = QuestionTypeEnum.single;
			break;
		case "1":
			en = QuestionTypeEnum.multiple;
			break;
		case "2":
			en = QuestionTypeEnum.truefalse;
			break;
		case "3":
			en = QuestionTypeEnum.blank;
			break;
		case "4":
			en = QuestionTypeEnum.shortanswer;
			break;
		case "5":
			en = QuestionTypeEnum.essay;
			break;
		default:
			break;
		}
		return en;
	}

}
