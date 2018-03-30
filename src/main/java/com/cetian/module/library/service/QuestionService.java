/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: QuestionService.java 
 * @date 2018年3月29日 上午10:50:49 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.library.dao.QuestionDao;
import com.cetian.module.library.entity.Question;

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
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage create(Question question) {
		ResponseMessage responseMessage = new ResponseMessage();
		
		
		questionDao.save(question);
		responseMessage.success();
		return responseMessage;
	}

}
