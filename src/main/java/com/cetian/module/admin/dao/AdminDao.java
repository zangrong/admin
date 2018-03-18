/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: AdminDao.java 
 * @date 2018年2月28日 下午3:06:12 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.admin.entity.Admin;

/**
 * @ClassName: AdminDao
 * @Description:TODO
 * @date: 2018年2月28日 下午3:06:12
 * @author: zangrong
 * 
 */
public interface AdminDao extends PagingAndSortingRepository<Admin, Long>, JpaSpecificationExecutor<Admin> {

	Admin findByUsername(String username);
	
}
