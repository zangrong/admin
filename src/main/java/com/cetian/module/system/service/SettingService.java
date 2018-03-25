/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: SettingService.java 
 * @date 2018年3月25日 下午3:24:13 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.module.system.dao.SettingDao;

/**
 * @ClassName:  SettingService   
 * @Description:TODO
 * @date:  2018年3月25日 下午3:24:13
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class SettingService {
	
	private SettingDao settingDao;
	
}
