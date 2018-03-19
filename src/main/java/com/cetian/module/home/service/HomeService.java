/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: HomeService.java 
 * @date 2018年3月19日 下午1:55:11 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.home.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetian.base.configuration.web.security.CtUserDetailsService;
import com.cetian.base.configuration.web.security.entity.SessionUser;

/**
 * @ClassName:  HomeService   
 * @Description:TODO
 * @date:  2018年3月19日 下午1:55:11
 * @author: zangrong
 * 
 */
@Service
public class HomeService {
	
	@Autowired
	private CtUserDetailsService ctUserDetailsService;
	
	/**
	 * @Title: home   
	 * @Description: 如果是第一次访问，则在session中创建 SessionUser 对象，并返回该用户的默认访问路径path
	 * @param session
	 * @return: String      
	 * @throws:
	 */
	public String home(HttpSession session) {
		SessionUser sessionUser = (SessionUser) session.getAttribute(SessionUser.SESSION_USER_KEY);
		// 如果 sessionUser 为null 则创建 sessionUser 到 session
		if (sessionUser == null) {
			sessionUser = ctUserDetailsService.createSessionUser(session);
			session.setAttribute(SessionUser.SESSION_USER_KEY, sessionUser);
		}
		return sessionUser.getPath();
	}
}
