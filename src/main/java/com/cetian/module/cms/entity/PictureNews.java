/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: PictureNews.java 
 * @date 2018年4月6日 下午7:56:42 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @ClassName:  PictureNews   
 * @Description: 图片新闻
 * @date:  2018年4月6日 下午7:56:42
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_cms_picture")
public class PictureNews extends Content{
	
	@Type(type = "json")
	private List<Picture> pictures;

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}
	
}
