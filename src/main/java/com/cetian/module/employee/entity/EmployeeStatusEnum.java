/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: EmployeeStatusEnum.java
 * @date 2018/7/3 14:35
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.employee.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: EmployeeStatusEnum
 * @Description: TODO
 * @date 2018/7/3 14:35
 * @author zangrong
 */
public enum EmployeeStatusEnum {

    delete(0), // 删除
    active(1),// 有效
    inactive(2),// 无效
    ;

    private int value;

    private EmployeeStatusEnum(int value) {
        // 必须是private的，否则编译错误
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
