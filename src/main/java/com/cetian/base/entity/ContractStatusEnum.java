/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: ContractStatusEnum.java
 * @date 2018/7/3 15:55
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: ContractStatusEnum
 * @Description: 合同状态
 * @date 2018/7/3 15:55
 * @author zangrong
 */
public enum ContractStatusEnum {

    invalid(0, "无效"), // 无效
    valid(1, "有效"),// 有效
    expired(2, "过期"),// 过期
    terminated(3, "终止"),// 终止
    ;

    private int value;
    private String name;

    private ContractStatusEnum(int value, String name) {
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
