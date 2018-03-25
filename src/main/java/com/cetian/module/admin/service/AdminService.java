/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AdminService.java 
 * @date 2018年2月28日 下午3:53:11 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.admin.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.admin.dao.AdminDao;
import com.cetian.module.admin.entity.Admin;
import com.cetian.module.system.dao.RoleDao;

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

	/**
	 * @Title: list   
	 * @Description: 管理员列表
	 * @param pageNo
	 * @param pageSize
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage list(int pageNo, int pageSize) {
		ResponseMessage responseMessage = new ResponseMessage();
		PageRequest pageRequest = PageRequest.of(pageNo -1, pageSize, Direction.ASC, "id");
		Page<Admin> page = adminDao.findAll(pageRequest);
		responseMessage.put(page);
		responseMessage.success();
		return responseMessage;
	}
}
