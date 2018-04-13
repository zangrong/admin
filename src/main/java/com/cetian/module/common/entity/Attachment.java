/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Attachment.java 
 * @date 2018年3月29日 上午10:16:04 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.common.entity;

/**
 * @ClassName:  Attachment   
 * @Description: 附件
 * @date:  2018年3月29日 上午10:16:04
 * @author: zangrong
 * 
 */
public class Attachment {
	private AttachmentTypeEnum type;
	private String url;
	public AttachmentTypeEnum getType() {
		return type;
	}
	public void setType(AttachmentTypeEnum type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
