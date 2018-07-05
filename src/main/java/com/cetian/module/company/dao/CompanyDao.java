/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: CompanyDao.java
 * @date 2018/7/3 23:24
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.company.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.company.entity.Company;

/**
 * @ClassName: CompanyDao
 * @Description: TODO
 * @date 2018/7/3 23:24
 * @author zangrong
 */
public interface CompanyDao extends PagingAndSortingRepository<Company, Long>, JpaSpecificationExecutor<Company> {

}
