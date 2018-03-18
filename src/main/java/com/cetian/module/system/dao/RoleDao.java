/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: RoleDao.java 
 * @date 2018年3月13日 下午3:55:10 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.system.entity.Role;

/**
 * @ClassName:  RoleDao   
 * @Description:TODO
 * @date:  2018年3月13日 下午3:55:10
 * @author: zangrong
 * 
 */
public interface RoleDao extends PagingAndSortingRepository<Role, Long>, JpaSpecificationExecutor<Role> {
	Role findByValue(String value);
	
	// 
	List<Role> findByValueIn(Collection<String> values);
}
