/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ArticleService.java 
 * @date 2018年4月6日 下午7:12:58 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.module.cms.dao.ArticleDao;
import com.cetian.module.cms.entity.Article;

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

	public List<Article> list(){
		
		
		return null;
	}
}
