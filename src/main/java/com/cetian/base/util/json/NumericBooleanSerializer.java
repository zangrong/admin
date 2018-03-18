/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: NumericBooleanSerializer.java 
 * @date 2017年3月13日 下午2:39:42 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @ClassName: NumericBooleanSerializer
 * @Description:TODO
 * @date: 2017年3月13日 下午2:39:42
 * @author: zangrong
 * 
 */
public class NumericBooleanSerializer extends JsonSerializer<Boolean> {
	@Override
	public void serialize(Boolean b, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {
		jsonGenerator.writeNumber(b ? 1 : 0);
	}
}
