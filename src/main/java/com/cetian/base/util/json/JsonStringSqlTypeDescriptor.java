/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: JsonStringSqlTypeDescriptor.java 
 * @date 2017年3月7日 下午4:31:07 
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

/**
 * @ClassName: JsonStringSqlTypeDescriptor
 * @Description:TODO
 * @date: 2017年3月7日 下午4:31:07
 * @author: zangrong
 * 
 */
public class JsonStringSqlTypeDescriptor extends AbstractJsonSqlTypeDescriptor {

	private static final long serialVersionUID = 2968636834026945957L;
	public static final JsonStringSqlTypeDescriptor INSTANCE = new JsonStringSqlTypeDescriptor();

	@Override
	public <X> ValueBinder<X> getBinder(final JavaTypeDescriptor<X> javaTypeDescriptor) {
		return new BasicBinder<X>(javaTypeDescriptor, this) {
			@Override
			protected void doBind(PreparedStatement st, X value, int index, WrapperOptions options)
					throws SQLException {
				st.setString(index, javaTypeDescriptor.unwrap(value, String.class, options));
			}

			@Override
			protected void doBind(CallableStatement st, X value, String name, WrapperOptions options)
					throws SQLException {
				st.setString(name, javaTypeDescriptor.unwrap(value, String.class, options));
			}
		};
	}
}
