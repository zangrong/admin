/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Question.java 
 * @date 2018年3月29日 上午9:41:33 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  Question   
 * @Description: 题目
 * @date:  2018年3月29日 上午9:41:33
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_question")
public class Question extends IdEntity{
	private String title;// 题目
	@Enumerated(EnumType.ORDINAL)
	private QuestionTypeEnum type;// 题型
	@Enumerated(EnumType.ORDINAL)
	private QuestionStatusEnum status;// 题目状态
	private String remark;// 备注信息，可能是题目的背景信息
	@Type(type = "json")
	private List<Attachment> attachments;// 附件资源url地址
	@Type(type = "json")
	private List<Option> options;// 备选项，选择题
	@Type(type = "json")
	private CorrectAnswer answer;//
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public QuestionTypeEnum getType() {
		return type;
	}
	public void setType(QuestionTypeEnum type) {
		this.type = type;
	}
	public QuestionStatusEnum getStatus() {
		return status;
	}
	public void setStatus(QuestionStatusEnum status) {
		this.status = status;
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
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public CorrectAnswer getAnswer() {
		return answer;
	}
	public void setAnswer(CorrectAnswer answer) {
		this.answer = answer;
	}
}
