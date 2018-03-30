/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: PaperDao.java 
 * @date 2018年3月29日 下午1:49:59 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.exam.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.exam.entity.Paper;

/**
 * @ClassName:  PaperDao   
 * @Description:TODO
 * @date:  2018年3月29日 下午1:49:59
 * @author: zangrong
 * 
 */
public interface PaperDao extends PagingAndSortingRepository<Paper, Long>, JpaSpecificationExecutor<Paper> {

}
