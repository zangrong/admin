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
public class KeyValue<K, V>{
	private K key;
	private V value;
	
	public KeyValue(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}
