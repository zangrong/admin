/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: JsonBinaryType.java 
 * @date 2017年3月7日 下午4:26:24 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util.json;

import java.util.Properties;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

/**
 * @ClassName: JsonBinaryType
 * @Description:TODO
 * @date: 2017年3月7日 下午4:26:24
 * @author: zangrong
 * 
 */
public class JsonBinaryType extends AbstractSingleColumnStandardBasicType<Object> implements DynamicParameterizedType {

	private static final long serialVersionUID = -9034519538798518505L;

	public JsonBinaryType() {
		super(JsonBinarySqlTypeDescriptor.INSTANCE, new JsonTypeDescriptor());
	}

	public String getName() {
		return "jsonb";
	}

	@Override
	public void setParameterValues(Properties parameters) {
		((JsonTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
	}

}
