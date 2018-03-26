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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.admin.entity.Admin;
import com.cetian.module.admin.service.AdminService;
import com.cetian.module.system.service.RoleService;

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
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public String list(Model model) {
		ResponseMessage responseMessage = adminService.all();
		model.addAllAttributes(responseMessage.getData());
		return "view/admin/list";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		ResponseMessage responseMessage = roleService.list();
		model.addAllAttributes(responseMessage.getData());
		return "view/admin/create";
	}
	
	@PostMapping("/create")
	public String create(Model model, Admin admin) {
		ResponseMessage responseMessage = adminService.create(admin);
		return "redirect:/admin";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, Long id) {
		ResponseMessage responseMessage = adminService.detail(id);
		model.addAllAttributes(responseMessage.getData());
		return "view/admin/detail";
	}
	
	
	
}
