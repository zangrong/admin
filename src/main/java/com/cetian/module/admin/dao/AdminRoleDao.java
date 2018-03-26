/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AdminRoleDao.java 
 * @date 2018年3月25日 下午5:18:59 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.admin.entity.AdminRole;

/**
 * @ClassName:  AdminRoleDao   
 * @Description:TODO
 * @date:  2018年3月25日 下午5:18:59
 * @author: zangrong
 * 
 */
public interface AdminRoleDao extends PagingAndSortingRepository<AdminRole, Long>, JpaSpecificationExecutor<AdminRole> {

}
