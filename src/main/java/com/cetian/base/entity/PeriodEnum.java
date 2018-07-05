/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: PeriodEnum.java
 * @date 2018/7/3 23:59
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: PeriodEnum
 * @Description: 结算周期
 * @date 2018/7/3 23:59
 * @author zangrong
 */
public enum PeriodEnum {

    month(0, "月"), // 月
    season(1, "季"),// 季
    halfYear(2, "半年"),// 半年
    allYear(3, "一年"),// 一年
    ;

    private String name;
    private int value;

    private PeriodEnum(int value, String name) {
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
