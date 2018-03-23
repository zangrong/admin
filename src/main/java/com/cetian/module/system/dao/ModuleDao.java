/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ModuleDao.java 
 * @date 2018年3月13日 下午3:55:53 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.system.entity.Module;

/**
 * @ClassName:  ModuleDao   
 * @Description:TODO
 * @date:  2018年3月13日 下午3:55:53
 * @author: zangrong
 * 
 */
public interface ModuleDao extends PagingAndSortingRepository<Module, Long>, JpaSpecificationExecutor<Module> {

	@Query("select m from Module m where m.parent=null order by sort asc")
	List<Module> findTopLevelOrderBySort();
}
