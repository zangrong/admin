/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AudioNews.java 
 * @date 2018年4月7日 上午9:55:57 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName:  AudioNews   
 * @Description: 音频内容
 * @date:  2018年4月7日 上午9:55:57
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "ct_cms_audio")
public class AudioNews extends Content{

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
