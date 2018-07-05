/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: EmployeeContractTypeEnum.java
 * @date 2018/7/3 15:55
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.employee.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: EmployeeContractTypeEnum
 * @Description: TODO
 * @date 2018/7/3 15:55
 * @author zangrong
 */
public enum EmployeeContractTypeEnum {

    sign(0, "新签"), // 新签
    renewal(1, "续签"),// 续签
    ;

    private int value;
    private String name;

    private EmployeeContractTypeEnum(int value, String name) {
        // 必须是private的，否则编译错误
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
