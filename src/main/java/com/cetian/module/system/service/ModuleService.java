/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ModuleService.java 
 * @date 2018年3月14日 下午4:58:17 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.module.system.dao.ModuleDao;
import com.cetian.module.system.entity.Module;

/**
 * @ClassName:  ModuleService   
 * @Description:TODO
 * @date:  2018年3月14日 下午4:58:17
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class ModuleService {
	
	private static final Logger log = LoggerFactory.getLogger(ModuleService.class);
	
	@Autowired
	private ModuleDao moduleDao;
	
	public List<Module> list(){
		return (List<Module>) moduleDao.findAll();
	}
	
	
}
