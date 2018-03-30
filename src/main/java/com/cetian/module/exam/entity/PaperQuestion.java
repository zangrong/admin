/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: PaperQuestion.java 
 * @date 2018年3月29日 下午1:20:49 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.exam.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  PaperQuestion   
 * @Description: 试题和题目关联表
 * @date:  2018年3月29日 下午1:20:49
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_paper_question")
public class PaperQuestion extends IdEntity{
	
	private Long paperId;
	private Long questionId;
	private int idx;// 序号
	private double point;// 该题分数
	
}
