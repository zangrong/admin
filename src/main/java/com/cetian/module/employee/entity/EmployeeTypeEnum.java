/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: EmployeeTypeEnum.java
 * @date 2018/7/3 14:35
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.employee.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: EmployeeTypeEnum
 * @Description: 员工类型
 * @date 2018/7/3 14:35
 * @author zangrong
 */
public enum EmployeeTypeEnum {

    other(0, "其他"), // 其他
    send(1, "派遣公司"), // 派遣公司
    self(2, "本公司"),// 本公司
    ;

    private int value;
    private String name;

    private EmployeeTypeEnum(int value, String name) {
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
