/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ArticleService.java 
 * @date 2018年4月6日 下午7:12:58 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.base.configuration.web.security.entity.SessionUser;
import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.cms.dao.ArticleDao;
import com.cetian.module.cms.entity.Article;
import com.cetian.module.cms.entity.ContentStatusEnum;

/**
 * @ClassName:  ArticleService   
 * @Description:TODO
 * @date:  2018年4月6日 下午7:12:58
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class ArticleService {

	
	private static final Logger log = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private ArticleDao articleDao;

	public Page<Article> list(int pageNo, int pageSize){
		Pageable pageable = PageRequest.of(pageNo-1, pageSize, Direction.DESC, "id");
		Page<Article> page = articleDao.findAll(pageable);
		return page;
	}

	/**
	 * @Title: create   
	 * @Description: 创建文章
	 * @param article
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage create(Article article, HttpSession session) {
		ResponseMessage responseMessage = new ResponseMessage();
		SessionUser sessionUser = (SessionUser)session.getAttribute(SessionUser.SESSION_USER_KEY);
		
		article.setStatus(ContentStatusEnum.draft);
		Date date = new Date();
		article.setCreateDate(date);
		article.setUpdateDate(date);
		article.setAdminId(sessionUser.getId());
		articleDao.save(article);
		responseMessage.success();
		return responseMessage;
	}
}
