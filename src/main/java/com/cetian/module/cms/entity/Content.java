/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Content.java 
 * @date 2018年4月6日 下午7:57:26 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  Content   
 * @Description: 内容抽象类
 * @date:  2018年4月6日 下午7:57:26
 * @author: zangrong
 * 
 */
@MappedSuperclass
public abstract class Content extends IdEntity{

	private String face;// 封面
	private String title; // 子标题
	private String subtitle;// 子标题
	private String author;// 作者
	private Long authorId;// 作者id，如果有的话
	private String tag;// 标签
	
	private int readCount;// 阅读数
	private int likeCount;// 点赞数
	private int commentCount;// 评论数
	private Long adminId;// 发布管理员的id
	private Date createDate;// 创建日期
	private Date updateDate;// 更新日期
	private String remark;// 备注，客户端不可见
	private ContentStatusEnum status;// 状态
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ContentStatusEnum getStatus() {
		return status;
	}
	public void setStatus(ContentStatusEnum status) {
		this.status = status;
	}
}
