/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: QuestionController.java 
 * @date 2018年3月29日 上午10:52:04 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cetian.base.entity.KeyValue;
import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.library.entity.Question;
import com.cetian.module.library.entity.QuestionTypeEnum;
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
	public String create(Model model, Question question, int[] optionIdx, String[] optionTitle, String[] optionRemark) {
		ResponseMessage responseMessage = questionService.create(question, optionIdx, optionTitle, optionRemark);
		return "redirect:/question";
	}
	
	@GetMapping("/update")
	public String update(Model model, Long id) {
		Question question = questionService.get(id);
		model.addAttribute("question", question);
		model.addAttribute("types", getTypes());
		return "view/library/question/update";
	}
	
	@PostMapping("/update")
	public String update(Model model, Question question, int[] optionIdx, String[] optionTitle, String[] optionRemark) {
		ResponseMessage responseMessage = questionService.update(question, optionIdx, optionTitle, optionRemark);
		return "redirect:/question";
	}
	
	@GetMapping("/get/{id}")
	@ResponseBody
	public Question get(@PathVariable Long id) {
		Question question = questionService.get(id);
		return question;
	}
	
	private static List<KeyValue> getTypes(){
		List<KeyValue> list = new ArrayList<>();
		list.add(new KeyValue("单选", QuestionTypeEnum.single.getValue()));
		list.add(new KeyValue("多选", QuestionTypeEnum.multiple.getValue()));
		list.add(new KeyValue("是非", QuestionTypeEnum.truefalse.getValue()));
		return list;
	}
	
}
