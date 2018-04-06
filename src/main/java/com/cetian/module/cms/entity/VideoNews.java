/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: VideoNews.java 
 * @date 2018年4月6日 下午7:57:01 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName:  VideoNews   
 * @Description:TODO
 * @date:  2018年4月6日 下午7:57:01
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_cms_video")
public class VideoNews extends Content{

	private String url;// 视频路径

	private String content;// 视频配文字

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
