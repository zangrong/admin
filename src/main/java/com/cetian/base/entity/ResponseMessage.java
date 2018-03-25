/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ResponseMessage.java 
 * @date 2018年3月25日 下午3:28:20 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;

/**
 * @ClassName:  ResponseMessage   
 * @Description:TODO
 * @date:  2018年3月25日 下午3:28:20
 * @author: zangrong
 * 
 */
public class ResponseMessage {
	
	public static final String KEY_COUNT = "count";// 当前页数据数
	public static final String KEY_TOTAL = "total";// 总数据数
	public static final String KEY_CONTENT = "content";// 数据
	public static final String KEY_PAGE_SIZE = "pageSize"; // 每页数据数
	public static final String KEY_PAGE_NO = "pageNo"; // 第几页 从1开始
	public static final String KEY_PAGE_TOTAL = "pageTotal"; // 共有多少页
	
	
	public static final int CODE_SUCCESS = 10000;// 正常成功
	public static final int CODE_FAILED = 20000;// 失败
	
	
	private boolean success;// 是否成功
	private int code;// 状态码
	private String message;// 附加消息
	private Map<String, Object> data = new HashMap<>();// 数据对象
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public void put(String key, Object value) {
		this.data.put(key, value);
	}
	
	public void put(Page<?> page) {
		this.data.put(KEY_CONTENT, page.getContent());
		this.data.put(KEY_COUNT, page.getNumberOfElements());
		this.data.put(KEY_TOTAL, page.getTotalElements());
		this.data.put(KEY_PAGE_NO, page.getNumber() + 1);
		this.data.put(KEY_PAGE_SIZE, page.getTotalElements());
		this.data.put(KEY_PAGE_TOTAL, page.getTotalPages());
	}
	
	public void success() {
		this.success = true;
		this.code = CODE_SUCCESS;
	}
}
