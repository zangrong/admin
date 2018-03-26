/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: LoginController.java 
 * @date 2018年2月28日 下午3:53:39 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetian.base.configuration.web.security.entity.SessionUser;

/**
 * @ClassName: LoginController
 * @Description:
 * @date: 2018年2月28日 下午3:53:39
 * @author: zangrong
 * 
 */
@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		SessionUser sessionUser = (SessionUser) session.getAttribute(SessionUser.SESSION_USER_KEY);
		if (sessionUser == null) {
			return "redirect:/login";
		}else {
			return "redirect:/home";
		}
	}

	@GetMapping("/login")
	public String login() {
		return "view/login";
	}

}
