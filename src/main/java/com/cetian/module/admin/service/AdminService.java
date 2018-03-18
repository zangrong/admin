/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: AdminService.java 
 * @date 2018年2月28日 下午3:53:11 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.module.admin.dao.AdminDao;
import com.cetian.module.admin.entity.Admin;
import com.cetian.module.system.dao.RoleDao;
import com.cetian.module.system.entity.Role;

/**
 * @ClassName:  AdminService   
 * @Description:TODO
 * @date:  2018年2月28日 下午3:53:11
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private RoleDao roleDao;
	
	public void test() {
		Admin  admin = new Admin();
		admin.setName("管理员");
		admin.setUsername("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		admin.setPassword(encoder.encode("admin"));
		admin.setCreateDate(new Date());
		adminDao.save(admin);
	}
	
	public Admin get(String username) {
		Admin admin = adminDao.findByUsername(username);
		return admin;
	}
	
	public Admin get(Long id) {
		Optional<Admin> admin = adminDao.findById(id);
		return admin.get();
	}
	
	public Admin getWithRoleList(Long id) {
		Optional<Admin> oa = adminDao.findById(id);
		Admin admin = oa.get();
		Set<String> roleSet = admin.getRoleSet();
		List<Role> roleList = roleDao.findByValueIn(roleSet);
		admin.setRoleList(roleList);
		return admin;
	}
	
	
}
