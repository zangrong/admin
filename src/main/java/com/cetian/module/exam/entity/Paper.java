/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Paper.java 
 * @date 2018年3月29日 下午1:11:12 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.exam.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  Paper   
 * @Description: 试卷
 * @date:  2018年3月29日 下午1:11:12
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_paper")
public class Paper extends IdEntity{

	private String name;
	private String remark;
	
	private int point;// 总分
	
	private int questionCount;// 题目总数
	
	private int questionTypeCount;// 题型数
	
	private Date createDate;
	private Date updateDate;
	
	@Transient
	private List<PaperPart> parts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public int getQuestionTypeCount() {
		return questionTypeCount;
	}

	public void setQuestionTypeCount(int questionTypeCount) {
		this.questionTypeCount = questionTypeCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<PaperPart> getParts() {
		return parts;
	}

	public void setParts(List<PaperPart> parts) {
		this.parts = parts;
	}
	
}
