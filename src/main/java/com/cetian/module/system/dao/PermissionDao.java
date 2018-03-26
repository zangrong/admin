/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: PermissionDao.java 
 * @date 2018年3月13日 下午3:56:30 
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

	@Query("select distinct p.value from Permission p")
	Set<String> findAllValue();
	
	@Query("select distinct p from Permission p,Role r,RolePermission rp where r.id=?1 and p.id=rp.permissionId and r.id=rp.roleId order by id asc")
	List<Permission> findByRoleId(Long roleId);
	
	@Query("select distinct p.value from Permission p,Role r,RolePermission rp,Admin a,AdminRole ar where a.id=?1 and a.id=ar.adminId and r.id=ar.roleId and p.id=rp.permissionId and r.id=rp.roleId")
	Set<String> findValueByAdminId(Long adminId);
	
	@Query("select distinct p from Permission p,Role r,RolePermission rp,Admin a,AdminRole ar where a.id=?1 and a.id=ar.adminId and r.id=ar.roleId and p.id=rp.permissionId and r.id=rp.roleId")
	Set<Permission> findByAdminId(Long adminId);
}
