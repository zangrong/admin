/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ModuleController.java 
 * @date 2018年3月19日 上午10:52:36 
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

import com.cetian.module.system.entity.Module;
import com.cetian.module.system.service.ModuleService;

/**
 * @ClassName:  ModuleController   
 * @Description:TODO
 * @date:  2018年3月19日 上午10:52:36
 * @author: zangrong
 * 
 */
@Controller
@RequestMapping("/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	@GetMapping
	public String all(Model model) {
		List<Module> modules = moduleService.all();
		model.addAttribute("modules", modules);
		return "view/module/all";
	}
	
	public String update() {
		
		return "";
	}
	
}
