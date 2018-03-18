/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: JsonStringType.java 
 * @date 2017年3月7日 下午4:27:27 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util.json;

import java.util.Properties;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

/**
 * @ClassName: JsonStringType
 * @Description:TODO
 * @date: 2017年3月7日 下午4:27:27
 * @author: zangrong
 * 
 */
public class JsonStringType extends AbstractSingleColumnStandardBasicType<Object> implements DynamicParameterizedType {

	private static final long serialVersionUID = -3115918705533859155L;

	public JsonStringType() {
		super(JsonStringSqlTypeDescriptor.INSTANCE, new JsonTypeDescriptor());
	}

	public String getName() {
		return "json";
	}

	@Override
	protected boolean registerUnderJavaType() {
		return true;
	}

	@Override
	public void setParameterValues(Properties parameters) {
		((JsonTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
	}
}
