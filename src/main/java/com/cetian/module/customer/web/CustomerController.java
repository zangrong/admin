/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: CustomerController.java
 * @date 2018/6/24 17:40
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.customer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cetian.module.customer.entity.Customer;
import com.cetian.module.customer.service.CustomerService;

/**
 * @ClassName: CustomerController
 * @Description: TODO
 * @date 2018/6/24 17:40
 * @author zangrong
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/create")
    @ResponseBody
    public String create(){
        customerService.create();
        return "create";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Customer> list(){
        List<Customer> list = customerService.list();
        return list;
    }

}
