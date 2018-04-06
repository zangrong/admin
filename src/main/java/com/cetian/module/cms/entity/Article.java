/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Article.java 
 * @date 2018年4月6日 下午7:02:34 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName:  Article   
 * @Description: 文章
 * @date:  2018年4月6日 下午7:02:34
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_cms_article")
public class Article extends Content{

	private String content;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
