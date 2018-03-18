/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: JsonBinarySqlTypeDescriptor.java 
 * @date 2017年3月7日 下午4:30:25 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util.json;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicBinder;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @ClassName: JsonBinarySqlTypeDescriptor
 * @Description:TODO
 * @date: 2017年3月7日 下午4:30:25
 * @author: zangrong
 * 
 */
public class JsonBinarySqlTypeDescriptor extends AbstractJsonSqlTypeDescriptor {

	private static final long serialVersionUID = 1995735159454967138L;
	public static final JsonBinarySqlTypeDescriptor INSTANCE = new JsonBinarySqlTypeDescriptor();

	@Override
	public <X> ValueBinder<X> getBinder(final JavaTypeDescriptor<X> javaTypeDescriptor) {
		return new BasicBinder<X>(javaTypeDescriptor, this) {
			@Override
			protected void doBind(PreparedStatement st, X value, int index, WrapperOptions options)
					throws SQLException {
				st.setObject(index, javaTypeDescriptor.unwrap(value, JsonNode.class, options), getSqlType());
			}

			@Override
			protected void doBind(CallableStatement st, X value, String name, WrapperOptions options)
					throws SQLException {
				st.setObject(name, javaTypeDescriptor.unwrap(value, JsonNode.class, options), getSqlType());
			}
		};
	}
}
