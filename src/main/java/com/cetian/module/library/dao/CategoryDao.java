/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CategoryDao.java 
 * @date 2018年3月30日 下午5:41:58 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.library.entity.Category;

/**
 * @ClassName:  CategoryDao   
 * @Description:TODO
 * @date:  2018年3月30日 下午5:41:58
 * @author: zangrong
 * 
 */
public interface CategoryDao extends PagingAndSortingRepository<Category, Long>, JpaSpecificationExecutor<Category> {

}
