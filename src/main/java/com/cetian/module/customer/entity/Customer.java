/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: Customer.java
 * @date 2018/6/24 17:15
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.customer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName: Customer
 * @Description: TODO
 * @date 2018/6/24 17:15
 * @author zangrong
 */
@Document
public class Customer {

    @Id
    private String id;

    private String firstname;
    private String lastname;

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
