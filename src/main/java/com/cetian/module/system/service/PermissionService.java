/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: PermissionService.java 
 * @date 2018年3月15日 下午4:02:44 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.module.system.dao.PermissionDao;
import com.cetian.module.system.entity.Permission;

/**
 * @ClassName:  PermissionService   
 * @Description:TODO
 * @date:  2018年3月15日 下午4:02:44
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class PermissionService {
	
	@Autowired
	private PermissionDao permissionDao;
	
	public List<Permission> getAll() {
		List<Permission> permissions = (List<Permission>) permissionDao.findAll();
		return permissions;
	}
	
	public Map<String, Permission> getKeyMap(){
		Map<String, Permission> map = new HashMap<>();
		Iterable<Permission> permissions = permissionDao.findAll();
		for (Permission permission : permissions) {
			map.put(permission.getValue(), permission);
		}
		return map;
	}
	
	public Map<Long, Permission> getIdMap(){
		Map<Long, Permission> map = new HashMap<>();
		Iterable<Permission> permissions = permissionDao.findAll();
		for (Permission permission : permissions) {
			map.put(permission.getId(), permission);
		}
		return map;
	}
	
	
	
}
