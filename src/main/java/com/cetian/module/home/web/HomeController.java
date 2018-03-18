/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
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

import com.cetian.base.configuration.web.security.CtUserDetailsService;
import com.cetian.base.configuration.web.security.entity.SessionUser;
import com.cetian.module.admin.service.AdminService;

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
	private CtUserDetailsService ctUserDetailsService;
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		
		SessionUser sessionUser = (SessionUser) session.getAttribute(SessionUser.SESSION_USER_KEY);
		// 如果 sessionUser 为null 则创建 sessionUser 到 session
		if (sessionUser == null) {
			ctUserDetailsService.createSessionUser(session);
		}
		// 重定向该用户到第一个能访问的路径
		return "home";
	}
	
	@RequestMapping("/test")
	public String test() {
		// 记录user信息到session
		// 准备权限模块信息
		// 需要研究SpringSecurity动态权限配置的实现
		return "test";
	}
}
