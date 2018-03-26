/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: HomeController.java 
 * @date 2018年2月28日 下午3:09:05 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.home.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetian.module.admin.service.AdminService;
import com.cetian.module.home.service.HomeService;

/**
 * @ClassName: HomeController
 * @Description:TODO
 * @date: 2018年2月28日 下午3:09:05
 * @author: zangrong
 * 
 */
@Controller
public class HomeController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		homeService.home(session);
		return "view/home/home";
	}
	
	@RequestMapping("/test")
	public String test() {
		// 记录user信息到session
		// 准备权限模块信息
		// 需要研究SpringSecurity动态权限配置的实现
		return "test";
	}
}
