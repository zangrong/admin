/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: WelcomeController.java 
 * @date 2018年3月19日 下午3:05:32 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.home.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName:  WelcomeController   
 * @Description:TODO
 * @date:  2018年3月19日 下午3:05:32
 * @author: zangrong
 * 
 */
@Controller("/welcome")
public class WelcomeController {

	@RequestMapping("")
	public String index() {
		System.out.println("xxxx");
		return "home/welcome";
	}
}
