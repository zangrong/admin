/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ColumnController.java 
 * @date 2018年4月16日 上午10:53:58 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.base.util.WebUtil;
import com.cetian.module.cms.entity.Column;
import com.cetian.module.cms.service.ColumnService;

/**
 * @ClassName:  ColumnController   
 * @Description:TODO
 * @date:  2018年4月16日 上午10:53:58
 * @author: zangrong
 * 
 */
@Controller
@RequestMapping("/cms/column")
public class ColumnController {
	
	@Autowired
	private ColumnService columnService;
	
	@GetMapping
	public String all(Model model) {
		List<Column> columns = columnService.all();
		model.addAttribute("columns", columns);
		return "view/cms/column/all";
	}
	
	@GetMapping("/create")
	public String create() {
		return "view/cms/column/create";
	}
	
	@PostMapping("/create")
	public String create(Column column) {
		ResponseMessage responseMessage = columnService.create(column);
		return WebUtil.redirect("/cms/column");
	}
	
	@GetMapping("/update")
	public String update(Model model, Long id) {
		Column column = columnService.get(id);
		model.addAttribute("column", column);
		return "view/cms/column/update";
	}
	
	@PostMapping("/update")
	public String update(Column column) {
		ResponseMessage responseMessage = columnService.update(column);
		return WebUtil.redirect("/cms/column");
	}
	
}
