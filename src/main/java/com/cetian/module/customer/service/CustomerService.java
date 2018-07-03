/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: CustomerService.java
 * @date 2018/6/24 17:53
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetian.module.customer.dao.CustomerDao;
import com.cetian.module.customer.entity.Customer;

/**
 * @ClassName: CustomerService
 * @Description: TODO
 * @date 2018/6/24 17:53
 * @author zangrong
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void create(){

        List<Customer> list = new ArrayList<>();
        Customer c1 = new Customer("aa", "bb");
        Customer c2 = new Customer("张三", "哈哈");
        Customer c3 = new Customer("王麻子", "王万");
        Customer c4 = new Customer("李四", "嘎嘎嘎");
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c3);
        customerDao.saveAll(list);

    }

    public List<Customer> list() {
        return customerDao.findAll();
    }
}
