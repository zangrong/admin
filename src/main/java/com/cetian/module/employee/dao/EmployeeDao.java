/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: EmployeeDao.java
 * @date 2018/7/3 23:24
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.employee.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.company.entity.Company;
import com.cetian.module.employee.entity.Employee;

/**
 * @ClassName: EmployeeDao
 * @Description: TODO
 * @date 2018/7/3 23:24
 * @author zangrong
 */
public interface EmployeeDao extends PagingAndSortingRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {


}
