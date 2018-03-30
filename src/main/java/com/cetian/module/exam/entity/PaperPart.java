/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: PaperPart.java 
 * @date 2018年3月29日 下午1:15:55 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.exam.entity;

import java.util.List;

import com.cetian.module.library.entity.Question;
import com.cetian.module.library.entity.QuestionTypeEnum;

/**
 * @ClassName:  PaperPart   
 * @Description: 试卷部分
 * @date:  2018年3月29日 下午1:15:55
 * @author: zangrong
 * 
 */
public class PaperPart {
	private int idx;// 序号
	private int itemPoint;// 单题得分
	private int point;// 总分
	private QuestionTypeEnum type;
	private List<Question> questions;
}
