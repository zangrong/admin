/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Column.java 
 * @date 2018年4月14日 下午9:17:52 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName:  Column   
 * @Description: 栏目
 * @date:  2018年4月14日 下午9:17:52
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_cms_column")
public class Column extends IdEntity{

	private String logo;// 栏目logo
	private String name;// 栏目名称
	private String remark; // 
	private boolean enable;
	private int readCount;// 阅读数
	private int commentCount;// 评论数
	private int totalCount;// 总内容数
	private int audioCount;// 音频数
	private int articleCount;// 文章数
	private int videoCount;// 视频数
	private int pictureCount;// 图片新闻数
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
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
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getAudioCount() {
		return audioCount;
	}
	public void setAudioCount(int audioCount) {
		this.audioCount = audioCount;
	}
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public int getVideoCount() {
		return videoCount;
	}
	public void setVideoCount(int videoCount) {
		this.videoCount = videoCount;
	}
	public int getPictureCount() {
		return pictureCount;
	}
	public void setPictureCount(int pictureCount) {
		this.pictureCount = pictureCount;
	}
	
}
