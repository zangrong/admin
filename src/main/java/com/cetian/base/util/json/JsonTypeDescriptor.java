/**
 * @Copyright: 2017 cetian.com Inc. All rights reserved. 
 * @Title: JsonTypeDescriptor.java 
 * @date 2017年3月7日 下午4:28:41 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util.json;

import java.util.Properties;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.MutableMutabilityPlan;
import org.hibernate.usertype.DynamicParameterizedType;

import com.cetian.base.util.JacksonUtil;

/**
 * @ClassName: JsonTypeDescriptor
 * @Description:TODO
 * @date: 2017年3月7日 下午4:28:41
 * @author: zangrong
 * 
 */
public class JsonTypeDescriptor extends AbstractTypeDescriptor<Object> implements DynamicParameterizedType {

	private static final long serialVersionUID = 1202214843105840880L;
	private Class<?> jsonObjectClass;

	@Override
	public void setParameterValues(Properties parameters) {
		jsonObjectClass = ((ParameterType) parameters.get(PARAMETER_TYPE)).getReturnedClass();

	}

	public JsonTypeDescriptor() {
		super(Object.class, new MutableMutabilityPlan<Object>() {
			private static final long serialVersionUID = -3646489267475639985L;

			@Override
			protected Object deepCopyNotNull(Object value) {
				return JacksonUtil.clone(value);
			}
		});
	}

	@Override
	public boolean areEqual(Object one, Object another) {
		if (one == another) {
			return true;
		}
		if (one == null || another == null) {
			return false;
		}
		return JacksonUtil.toJsonNode(JacksonUtil.toString(one))
				.equals(JacksonUtil.toJsonNode(JacksonUtil.toString(another)));
	}

	@Override
	public String toString(Object value) {
		return JacksonUtil.toString(value);
	}

	@Override
	public Object fromString(String string) {
		return JacksonUtil.fromString(string, jsonObjectClass);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <X> X unwrap(Object value, Class<X> type, WrapperOptions options) {
		if (value == null) {
			return null;
		}
		if (String.class.isAssignableFrom(type)) {
			return (X) toString(value);
		}
		if (Object.class.isAssignableFrom(type)) {
			return (X) JacksonUtil.toJsonNode(toString(value));
		}
		throw unknownUnwrap(type);
	}

	@Override
	public <X> Object wrap(X value, WrapperOptions options) {
		if (value == null) {
			return null;
		}
		return fromString(value.toString());
	}

}
