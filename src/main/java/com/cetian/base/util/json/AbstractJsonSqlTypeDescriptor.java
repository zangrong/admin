/**
 * @Copyright: 2017 cetian.com Inc. All rights reserved. 
 * @Title: AbstractJsonSqlTypeDescriptor.java 
 * @date 2017年3月7日 下午4:29:46 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util.json;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.type.descriptor.ValueExtractor;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicExtractor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

/**
 * @ClassName: AbstractJsonSqlTypeDescriptor
 * @Description:TODO
 * @date: 2017年3月7日 下午4:29:46
 * @author: zangrong
 * 
 */
public abstract class AbstractJsonSqlTypeDescriptor implements SqlTypeDescriptor {

	private static final long serialVersionUID = -4422030187133551527L;

	@Override
	public int getSqlType() {
		return Types.OTHER;
	}

	@Override
	public boolean canBeRemapped() {
		return true;
	}

	@Override
	public <X> ValueExtractor<X> getExtractor(final JavaTypeDescriptor<X> javaTypeDescriptor) {
		return new BasicExtractor<X>(javaTypeDescriptor, this) {
			@Override
			protected X doExtract(ResultSet rs, String name, WrapperOptions options) throws SQLException {
				return javaTypeDescriptor.wrap(rs.getObject(name), options);
			}

			@Override
			protected X doExtract(CallableStatement statement, int index, WrapperOptions options) throws SQLException {
				return javaTypeDescriptor.wrap(statement.getObject(index), options);
			}

			@Override
			protected X doExtract(CallableStatement statement, String name, WrapperOptions options)
					throws SQLException {
				return javaTypeDescriptor.wrap(statement.getObject(name), options);
			}
		};
	}

}
