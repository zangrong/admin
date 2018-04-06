/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ArticleDao.java 
 * @date 2018年4月6日 下午7:12:09 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.cms.entity.Article;

/**
 * @ClassName:  ArticleDao   
 * @Description:TODO
 * @date:  2018年4月6日 下午7:12:09
 * @author: zangrong
 * 
 */
public interface ArticleDao extends PagingAndSortingRepository<Article, Long>, JpaSpecificationExecutor<Article> {

}
