/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CategoryService.java 
 * @date 2018年3月30日 下午5:42:34 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.module.library.dao.CategoryDao;
import com.cetian.module.library.entity.Category;

/**
 * @ClassName:  CategoryService   
 * @Description:TODO
 * @date:  2018年3月30日 下午5:42:34
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	/**
	 * @Title: all   
	 * @Description: 
	 * @return: List<Category>      
	 * @throws: 
	 */
	public List<Category> all() {
		return (List<Category>) categoryDao.findAll();
	}
	
	
}
