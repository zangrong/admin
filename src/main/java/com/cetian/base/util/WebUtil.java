/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: WebUtil.java 
 * @date 2018年3月30日 下午5:48:09 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util;

/**
 * @ClassName:  WebUtil   
 * @Description:TODO
 * @date:  2018年3月30日 下午5:48:09
 * @author: zangrong
 * 
 */
public class WebUtil {
	
	public static final String REDIRECT = "redirect:";
	
	public static String redirect(String path) {
		return REDIRECT + path;
	}
}
