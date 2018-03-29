/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AdminService.java 
 * @date 2018年2月28日 下午3:53:11 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.admin.dao.AdminDao;
import com.cetian.module.admin.dao.AdminRoleDao;
import com.cetian.module.admin.entity.Admin;
import com.cetian.module.admin.entity.AdminRole;
import com.cetian.module.admin.entity.AdminStatusEnum;
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
	@Autowired
	private AdminRoleDao adminRoleDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Admin get(String username) {
		Admin admin = adminDao.findByUsername(username);
		return admin;
	}
	
	public Admin get(Long id) {
		Optional<Admin> admin = adminDao.findById(id);
		return admin.get();
	}

	/**
	 * @Title: list   
	 * @Description: 管理员列表
	 * @param pageNo
	 * @param pageSize
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	@Deprecated
	public ResponseMessage list(int pageNo, int pageSize) {
		ResponseMessage responseMessage = new ResponseMessage();
		PageRequest pageRequest = PageRequest.of(pageNo -1, pageSize, Direction.ASC, "id");
		Page<Admin> page = adminDao.findAll(pageRequest);
		responseMessage.put(page);
		responseMessage.success();
		return responseMessage;
	}
	
	public ResponseMessage all() {
		ResponseMessage responseMessage = new ResponseMessage();
		Iterable<Admin> admins = adminDao.findAll();
		for (Admin admin : admins) {
			List<Role> roles = roleDao.findByAdminId(admin.getId());
			admin.setRoles(roles);
		}
		responseMessage.put("admins", admins);
		responseMessage.success();
		return responseMessage;
	}
	
	public ResponseMessage create(Admin admin, Long[] roleId) {
		ResponseMessage responseMessage = new ResponseMessage();
		// 登录名不能重名 TODO
		
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		admin.setStatus(AdminStatusEnum.active);
		Date date = new Date();
		admin.setCreateDate(date);
		admin.setUpdateDate(date);
		
		adminDao.save(admin);
		// 添加角色 判断role存在和去重
		for (Long rid : roleId) {
			AdminRole ar = new AdminRole();
			ar.setAdminId(admin.getId());
			ar.setRoleId(rid);
			adminRoleDao.save(ar);
		}
		
		responseMessage.put("admin", admin);
		responseMessage.success();
		return responseMessage;
	}

	/**
	 * @Title: detail   
	 * @Description: 查找一个admin
	 * @param id
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage detail(Long id) {
		ResponseMessage responseMessage = new ResponseMessage();
		Optional<Admin> optional = adminDao.findById(id);
		if (!optional.isPresent()) {
			responseMessage.notFound();
			return responseMessage;
		}
		responseMessage.put("admin", optional.get());
		responseMessage.success();
		return responseMessage;
	}
}
