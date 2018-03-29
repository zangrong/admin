/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AdminController.java 
 * @date 2018年2月28日 下午3:53:55 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.admin.entity.Admin;
import com.cetian.module.admin.service.AdminService;
import com.cetian.module.system.entity.Role;
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
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public String all(Model model) {
		ResponseMessage responseMessage = adminService.all();
		model.addAllAttributes(responseMessage.getData());
		return "view/admin/all";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		List<Role> roles = roleService.all();
		model.addAttribute("roles", roles);
		return "view/admin/create";
	}
	
	@PostMapping("/create")
	public String create(Model model, Admin admin, Long[] roleId) {
		ResponseMessage responseMessage = adminService.create(admin, roleId);
		// TODO 消息提示问题
		return "redirect:/admin";
	}
	
	@GetMapping("/update")
	public String update(Model model, Long id) {
		log.warn("update id[{}]", id);
		Admin admin = adminService.get(id);
		model.addAttribute("admin", admin);
		List<Role> roles = roleService.all();
		model.addAttribute("roles", roles);
		return "view/admin/update";
	}
	
	
	
}
