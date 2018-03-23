/**
 * @Copyright: 2017 cetian.com Inc. All rights reserved. 
 * @Title: ObjectUtil.java 
 * @date 2017年4月13日 下午4:23:45 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: ObjectUtil
 * @Description:
 * @date: 2017年4月13日 下午4:23:45
 * @author: zangrong
 * 
 */
public class ObjectUtil {

	private static final DecimalFormat NUMBER_FORMAT = (DecimalFormat) DecimalFormat.getInstance();

	static {
		NUMBER_FORMAT.setGroupingSize(3);
	}

	/**
	 * Object null = "";<br/>
	 * Object obj = obj.toString().trim();<br/>
	 * String "abc" = "abc";<br/>
	 * String " abc " = "abc";<br/>
	 * 
	 * @Title: trimToEmpty
	 * @Description: 把一个对象转成对应字符串，如果为null则返回空字符串""
	 * @param obj
	 * @return: String
	 * @throws:
	 */
	public static String trimToEmpty(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return StringUtils.trim(obj.toString());
		}
	}

	/**
	 * Boolean null = 0;<br/>
	 * Boolean false = 0;<br/>
	 * Boolean true = 1;<br/>
	 * 
	 * @Title: trimToEmpty
	 * @Description: 处理一个Boolean对象，如果为null则返回"0",如果为true则返回"1"，如果为false则返回"0"
	 * @param obj
	 * @return: String
	 * @throws:
	 */
	public static int trimToEmpty(Boolean obj) {
		if (obj == null) {
			return 0;
		} else {
			return obj ? 1 : 0;
		}
	}

	public static Long trimToEmpty(Long obj) {
		if (obj == null) {
			return 0L;
		} else {
			return obj;
		}
	}

	public static Integer trimToEmpty(Integer obj) {
		if (obj == null) {
			return 0;
		} else {
			return obj;
		}
	}

	/**
	 * 
	 * @Title: getStringWithdefaultValue
	 * @Description: 如果value是null返回dafaultValue
	 * @param value
	 * @param dafaultValue
	 * @return
	 * @return: String
	 * @throws:
	 */
	public static String getStringWithdefaultValue(Object value, String dafaultValue) {
		if (value == null) {
			return dafaultValue;
		}
		return value.toString();
	}

	public static String deleteEnterAndSpace(String data) {
		Pattern p = Pattern.compile("\\s{2,}|\t|\r|\n|&#x([^a|A|d|D]|.{2});");
		Matcher m = p.matcher(data);
		return m.replaceAll("");
	}

	public static boolean equals(Object obj, String value) {
		return (obj != null && obj.toString().equals(value));
	}

	public static boolean isNotNull(Object obj) {
		return (obj != null && obj.toString().length() != 0);
	}

	/**
	 * @Title: numberFormat
	 * @Description: 给数字格式化
	 * @param num
	 * @return: String
	 * @throws:
	 */
	public static String numberFormat(Integer num) {
		if (num == null) {
			return "0";
		}
		String format = NUMBER_FORMAT.format(num);
		return format;
	}

	public static String numberFormat(Long num) {
		if (num == null) {
			return "0";
		}
		String format = NUMBER_FORMAT.format(num);
		return format;
	}

}
