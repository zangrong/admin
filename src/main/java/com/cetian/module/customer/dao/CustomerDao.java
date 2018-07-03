/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: CustomerDao.java
 * @date 2018/6/24 17:45
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.customer.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cetian.module.customer.entity.Customer;

/**
 * @ClassName: CustomerDao
 * @Description: TODO
 * @date 2018/6/24 17:45
 * @author zangrong
 */
public interface CustomerDao extends MongoRepository<Customer, String> {

    public Customer findByFirstname(String firstname);
    public List<Customer> findByLastname(String lastname);

}
