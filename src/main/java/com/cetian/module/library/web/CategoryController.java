/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CategoryController.java 
 * @date 2018年3月30日 下午5:43:33 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetian.base.util.WebUtil;
import com.cetian.module.library.entity.Category;
import com.cetian.module.library.service.CategoryService;

/**
 * @ClassName:  CategoryController   
 * @Description:TODO
 * @date:  2018年3月30日 下午5:43:33
 * @author: zangrong
 * 
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String all(Model model) {
		List<Category> categories = categoryService.all();
		model.addAttribute("categories", categories);
		return "view/library/category/all";
	}
	
	@GetMapping("/create")
	public String create() {
		return "view/library/category/create";
	}
	
	@PostMapping("/create")
	public String create(Category category) {
		return WebUtil.redirect("/category");
	}
}
