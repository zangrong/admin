/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Picture.java 
 * @date 2018年4月6日 下午8:05:49 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.entity;

/**
 * @ClassName:  Picture   
 * @Description: 图片新闻的图片，不直接持久化
 * @date:  2018年4月6日 下午8:05:49
 * @author: zangrong
 * 
 */
public class Picture {
	private int idx;// 序号
	private String url;// 图片路径
	private String content; // 图片配的文字
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
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
