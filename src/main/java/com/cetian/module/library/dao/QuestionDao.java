/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: QuestionDao.java 
 * @date 2018年3月29日 上午10:49:53 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.library.entity.Question;

/**
 * @ClassName:  QuestionDao   
 * @Description:TODO
 * @date:  2018年3月29日 上午10:49:53
 * @author: zangrong
 * 
 */
public interface QuestionDao extends PagingAndSortingRepository<Question, Long>, JpaSpecificationExecutor<Question> {

}
