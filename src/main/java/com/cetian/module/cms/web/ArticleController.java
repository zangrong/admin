/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ArticleController.java 
 * @date 2018年4月7日 下午2:10:45 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.base.util.WebUtil;
import com.cetian.module.cms.entity.Article;
import com.cetian.module.cms.service.ArticleService;

/**
 * @ClassName:  ArticleController   
 * @Description:TODO
 * @date:  2018年4月7日 下午2:10:45
 * @author: zangrong
 * 
 */
@Controller
@RequestMapping("/cms/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping
	public String list(Model model, @RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		Page<Article> articles = articleService.list(pageNo, pageSize);
		model.addAttribute("articles", articles);
		return "view/cms/article/list";
	}
	
	@GetMapping("/create")
	public String create() {
		return "view/cms/article/create";
	}
	
	@PostMapping("/create")
	public String create(Article article, HttpSession session) {
		ResponseMessage responseMessage = articleService.create(article, session);
		return WebUtil.redirect("/cms/article");
	}
	
}
