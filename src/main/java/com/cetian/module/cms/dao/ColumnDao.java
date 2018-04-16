/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ColumnDao.java 
 * @date 2018年4月15日 下午8:53:57 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.cms.entity.Column;

/**
 * @ClassName:  ColumnDao   
 * @Description:TODO
 * @date:  2018年4月15日 下午8:53:57
 * @author: zangrong
 * 
 */
public interface ColumnDao extends PagingAndSortingRepository<Column, Long>, JpaSpecificationExecutor<Column> {

}
