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
	public QuestionTypeEnum getType() {
		return type;
	}
	public void setType(QuestionTypeEnum type) {
		this.type = type;
	}
	public int getSingle() {
		return single;
	}
	public void setSingle(int single) {
		this.single = single;
	}
	public int[] getMultiple() {
		return multiple;
	}
	public void setMultiple(int[] multiple) {
		this.multiple = multiple;
	}
	public boolean isTruefalse() {
		return truefalse;
	}
	public void setTruefalse(boolean truefalse) {
		this.truefalse = truefalse;
	}
	public String[] getBlank() {
		return blank;
	}
	public void setBlank(String[] blank) {
		this.blank = blank;
	}
	public String getShortanswer() {
		return shortanswer;
	}
	public void setShortanswer(String shortanswer) {
		this.shortanswer = shortanswer;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
}
