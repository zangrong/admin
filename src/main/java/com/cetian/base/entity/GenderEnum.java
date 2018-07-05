/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: GenderEnum.java
 * @date 2018/7/3 17:08
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: GenderEnum
 * @Description: 性别
 * @date 2018/7/3 17:08
 * @author zangrong
 */
public enum GenderEnum {
    female(0, "女"), // 女
    male(1, "男"),// 男
    unknown(2, "未知"),// 未知
    ;

    private String name;
    private int value;

    private GenderEnum(int value, String name) {
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
