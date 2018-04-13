/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: UploadResponse.java 
 * @date 2018年4月9日 上午2:05:37 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.common.entity;

/**
 * @ClassName:  UploadResponse   
 * @Description:TODO
 * @date:  2018年4月9日 上午2:05:37
 * @author: zangrong
 * 
 */
public class UploadResponse {
	
	public static final int SUCCESS = 1;
	
	private int uploaded;
	private String fileName;
	private String url;
	public int getUploaded() {
		return uploaded;
	}
	public void setUploaded(int uploaded) {
		this.uploaded = uploaded;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
