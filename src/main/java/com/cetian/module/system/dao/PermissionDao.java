/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: PermissionDao.java 
 * @date 2018年3月13日 下午3:56:30 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.system.entity.Permission;

/**
 * @ClassName:  PermissionDao   
 * @Description:TODO
 * @date:  2018年3月13日 下午3:56:30
 * @author: zangrong
 * 
 */
public interface PermissionDao extends PagingAndSortingRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {

	Collection<Permission> findByModuleId(Long id);

}
