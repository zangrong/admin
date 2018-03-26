/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: RolePermissionDao.java 
 * @date 2018年3月25日 下午5:21:26 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.system.entity.RolePermission;

/**
 * @ClassName:  RolePermissionDao   
 * @Description:TODO
 * @date:  2018年3月25日 下午5:21:26
 * @author: zangrong
 * 
 */
public interface RolePermissionDao extends PagingAndSortingRepository<RolePermission, Long>, JpaSpecificationExecutor<RolePermission> {

}
