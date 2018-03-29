/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: RoleDao.java 
 * @date 2018年3月13日 下午3:55:10 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
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
	
	@Query("select distinct r.value from Role r,Admin a,AdminRole ar where a.id=?1 and a.id=ar.adminId and r.id=ar.roleId")
	Set<String> findValueByAdminId(Long adminId);
	
	@Query("select distinct r from Role r,Admin a,AdminRole ar where a.id=?1 and a.id=ar.adminId and r.id=ar.roleId order by r.id asc")
	List<Role> findByAdminId(Long adminId);
}
