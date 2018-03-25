/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AdminController.java 
 * @date 2018年2月28日 下午3:53:55 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.admin.service.AdminService;

/**
 * @ClassName:  AdminController   
 * @Description:TODO
 * @date:  2018年2月28日 下午3:53:55
 * @author: zangrong
 * 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public String list(Model model, int pageNo, int pageSize) {
		ResponseMessage responseMessage = adminService.list(pageNo, pageSize);
		model.addAllAttributes(responseMessage.getData());
		return "admin/list";
	}
	
	
}
