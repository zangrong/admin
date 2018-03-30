/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: QuestionController.java 
 * @date 2018年3月29日 上午10:52:04 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.library.entity.Question;
import com.cetian.module.library.service.QuestionService;

/**
 * @ClassName:  QuestionController   
 * @Description:TODO
 * @date:  2018年3月29日 上午10:52:04
 * @author: zangrong
 * 
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping
	public String list(Model model) {
		Page<Question> questions = questionService.list(1, 10);
		model.addAttribute("questions", questions);
		return "view/library/question/list";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		return "view/library/question/create";
	}
	
	@PostMapping("/create")
	public String create(Model model, Question question) {
		ResponseMessage responseMessage = questionService.create(question);
		return "redirect:/question";
	}
	
}
