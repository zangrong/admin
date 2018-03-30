/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: KeyValue.java 
 * @date 2018年3月30日 下午2:44:03 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.entity;

/**
 * @ClassName:  KeyValue   
 * @Description:TODO
 * @date:  2018年3月30日 下午2:44:03
 * @author: zangrong
 * 
 */
public class KeyValue {
	private Object key;
	private Object value;
	
	public KeyValue(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}
