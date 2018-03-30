/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: QuestionService.java 
 * @date 2018年3月29日 上午10:50:49 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.library.dao.QuestionDao;
import com.cetian.module.library.entity.CorrectAnswer;
import com.cetian.module.library.entity.Option;
import com.cetian.module.library.entity.Question;
import com.cetian.module.library.entity.QuestionStatusEnum;
import com.cetian.module.library.entity.QuestionTypeEnum;

/**
 * @ClassName:  QuestionService   
 * @Description:TODO
 * @date:  2018年3月29日 上午10:50:49
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class QuestionService {
	
	private static final Logger log = LoggerFactory.getLogger(QuestionService.class);

	@Autowired
	private QuestionDao questionDao;
	
	/**
	 * @Title: list   
	 * @Description: 分页获取题目列表 
	 * @param pageNo
	 * @param pageSize
	 * @return: Page<Question>      
	 * @throws: 
	 */
	public Page<Question> list(int pageNo, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize);
		Page<Question> page = questionDao.findAll(pageRequest);
		return page;
	}

	/**
	 * @Title: create   
	 * @Description: 创建题目
	 * @param question
	 * @param optionRemark 
	 * @param optionName 
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage create(Question question, int[] optionIdx, String[] optionTitle, String[] optionRemark) {
		ResponseMessage responseMessage = new ResponseMessage();
		QuestionTypeEnum type = question.getType();
		List<Option> options = new ArrayList<>();
		CorrectAnswer answer = new CorrectAnswer();
		answer.setType(type);
		switch (type) {
		case single:
			for (int i = 0; i < optionTitle.length; i++) {
				Option opt = new Option();
				opt.setTitle(optionTitle[i]);
				opt.setIndex(i);
				options.add(opt);
			}
			question.setStatus(QuestionStatusEnum.valid);
			question.setOptions(options);
			
			answer.setSingle(optionIdx[0]);
			question.setAnswer(answer);
			break;
		case multiple:
			for (int i = 0; i < optionTitle.length; i++) {
				Option opt = new Option();
				opt.setTitle(optionTitle[i]);
				opt.setIndex(i);
				options.add(opt);
			}
			question.setStatus(QuestionStatusEnum.valid);
			question.setOptions(options);
			
			answer.setMultiple(optionIdx);
			question.setAnswer(answer);
			break;
		default:
			log.warn("题目类型不正确[{}]", type);
			break;
		}
		
		question.setCreateDate(new Date());
		questionDao.save(question);
		responseMessage.success();
		return responseMessage;
	}

	/**
	 * @Title: get   
	 * @Description: 
	 * @param id
	 * @return: Question      
	 * @throws: 
	 */
	public Question get(Long id) {
		Optional<Question> optional = questionDao.findById(id);
		return optional.get();
	}

	/**
	 * @Title: update   
	 * @Description: 
	 * @param question
	 * @param optionIdx
	 * @param optionTitle
	 * @param optionRemark
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage update(Question question, int[] optionIdx, String[] optionTitle, String[] optionRemark) {
		ResponseMessage responseMessage = new ResponseMessage();
		QuestionTypeEnum type = question.getType();
		Optional<Question> optional = questionDao.findById(question.getId());
		
		Question exist = optional.get();
		List<Option> options = new ArrayList<>();
		CorrectAnswer answer = new CorrectAnswer();
		answer.setType(type);
		switch (type) {
		case single:
			for (int i = 0; i < optionTitle.length; i++) {
				Option opt = new Option();
				opt.setTitle(optionTitle[i]);
				opt.setIndex(i);
				options.add(opt);
			}
			exist.setOptions(options);
			
			answer.setSingle(optionIdx[0]);
			exist.setAnswer(answer);
			break;
		case multiple:
			for (int i = 0; i < optionTitle.length; i++) {
				Option opt = new Option();
				opt.setTitle(optionTitle[i]);
				opt.setIndex(i);
				options.add(opt);
			}
			exist.setOptions(options);
			
			answer.setMultiple(optionIdx);
			exist.setAnswer(answer);
			break;
		default:
			log.warn("题目类型不正确[{}]", type);
			break;
		}
		
		questionDao.save(exist);
		responseMessage.success();
		return responseMessage;
	}

}
