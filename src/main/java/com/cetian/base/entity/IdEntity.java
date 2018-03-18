/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: IdEntity.java 
 * @date 2017年2月27日 下午3:33:52 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.cetian.base.util.json.JsonBinaryType;
import com.cetian.base.util.json.JsonStringType;

/**
 * 
 * @ClassName: IdEntity
 * @Description: 数据库持久化对象父类，该类 子类对象 只保存到数据库，不建立搜索索引
 * @date: 2017年2月27日 下午3:30:57
 * @author: zangrong
 *
 */
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
@MappedSuperclass
public abstract class IdEntity implements Serializable {

	private static final long serialVersionUID = 8890435079654208095L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}