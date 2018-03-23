/**
 * @Copyright: 2017 cetian.com Inc. All rights reserved. 
 * @Title: JacksonUtil.java 
 * @date 2017年3月7日 下午4:13:53 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName: JacksonUtil
 * @Description: Json工具类
 * @date: 2017年3月7日 下午4:13:53
 * @author: zangrong
 * 
 */
public class JacksonUtil {

	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static <T> T fromString(String string, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(string, clazz);
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"The given string value: " + string + " cannot be transformed to Json object");
		}
	}

	public static String toString(Object value) {
		try {
			return OBJECT_MAPPER.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException(
					"The given Json object value: " + value + " cannot be transformed to a String");
		}
	}

	public static JsonNode toJsonNode(String value) {
		try {
			return OBJECT_MAPPER.readTree(value);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T clone(T value) {
		return fromString(toString(value), (Class<T>) value.getClass());
	}

	/**
	 * 
	 * @Title: formatJson
	 * @Description: 格式化输出json字符串
	 * @param jsonStr
	 * @return: String
	 * @throws:
	 */
	public static String formatJson(String jsonStr) {
		if (null == jsonStr || "".equals(jsonStr))
			return "";
		StringBuilder sb = new StringBuilder();
		char last = '\0';
		char current = '\0';
		int indent = 0;
		for (int i = 0; i < jsonStr.length(); i++) {
			last = current;
			current = jsonStr.charAt(i);
			switch (current) {
			case '{':
			case '[':
				sb.append(current);
				sb.append('\n');
				indent++;
				addIndentBlank(sb, indent);
				break;
			case '}':
			case ']':
				sb.append('\n');
				indent--;
				addIndentBlank(sb, indent);
				sb.append(current);
				break;
			case ',':
				sb.append(current);
				if (last != '\\') {
					sb.append('\n');
					addIndentBlank(sb, indent);
				}
				break;
			default:
				sb.append(current);
			}
		}
		return sb.toString();
	}

	private static void addIndentBlank(StringBuilder sb, int indent) {
		for (int i = 0; i < indent; i++) {
			sb.append('\t');
		}
	}

}
