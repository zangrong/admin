/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Option.java 
 * @date 2018年3月29日 上午9:45:56 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.entity;

import java.util.List;

import com.cetian.module.common.entity.Attachment;

/**
 * @ClassName:  Option   
 * @Description: 备选项，通过json持久化
 * @date:  2018年3月29日 上午9:45:56
 * @author: zangrong
 * 
 */
public class Option {
	private int index;
	private String title;// 选项说明
	private String remark;// 备注
	private List<Attachment> attachments;// 图片
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
