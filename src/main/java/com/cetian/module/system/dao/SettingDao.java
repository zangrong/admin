/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: SettingDao.java 
 * @date 2018年3月25日 下午3:22:22 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.system.entity.Setting;

/**
 * @ClassName:  SettingDao   
 * @Description:TODO
 * @date:  2018年3月25日 下午3:22:22
 * @author: zangrong
 * 
 */
public interface SettingDao extends PagingAndSortingRepository<Setting, Long>, JpaSpecificationExecutor<Setting> {

}
