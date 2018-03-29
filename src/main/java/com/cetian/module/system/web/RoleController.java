/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: RoleController.java 
 * @date 2018年3月19日 上午10:53:12 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetian.module.admin.service.AdminService;
import com.cetian.module.system.entity.Role;
import com.cetian.module.system.service.RoleService;

/**
 * @ClassName:  RoleController   
 * @Description:TODO
 * @date:  2018年3月19日 上午10:53:12
 * @author: zangrong
 * 
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public String all(Model model) {
		List<Role> roles = roleService.all();
		model.addAttribute("roles", roles);
		return "view/system/role/all";
	}
}
