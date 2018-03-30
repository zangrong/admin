/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CorrectAnswer.java 
 * @date 2018年3月29日 上午9:44:46 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.entity;

import java.util.List;

/**
 * @ClassName:  CorrectAnswer   
 * @Description: 正确答案，通过json持久化
 * @date:  2018年3月29日 上午9:44:46
 * @author: zangrong
 * 
 */
public class CorrectAnswer {
	private QuestionTypeEnum type;
	private int single;// 单选题答案
	private int[] multiple;// 多选题答案
	private boolean truefalse;// 是非题答案
	private String[] blank;// 填空题答案
	private String shortanswer;// 简单题答案
	private String remark;// 答案的备注说明
	private List<Attachment> attachments;// 答案附件
	
}
