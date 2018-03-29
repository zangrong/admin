/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: RoleService.java 
 * @date 2018年3月14日 下午5:15:17 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.module.system.dao.RoleDao;
import com.cetian.module.system.entity.Role;

/**
 * @ClassName:  RoleService   
 * @Description:TODO
 * @date:  2018年3月14日 下午5:15:17
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;

	/**
	 * @Title: all   
	 * @Description: 所有角色
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public List<Role> all() {
		List<Role> roles = (List<Role>) roleDao.findAll();
		return roles;
	}

}
