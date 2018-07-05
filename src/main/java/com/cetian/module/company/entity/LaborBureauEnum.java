/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: LaborBureauEnum.java
 * @date 2018/7/3 17:17
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.company.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: LaborBureauEnum
 * @Description: 劳动就业服务局
 * @date 2018/7/3 17:17
 * @author zangrong
 */
public enum LaborBureauEnum {

    other(0, "其他"), // 其他
    panlong(1, "盘龙区劳动就业服务局"), // 盘龙区劳动就业服务局
    wuhua(2, "五华区劳动就业服务局"), // 五华区劳动就业服务局
    xishan(3, "西山区劳动就业服务局"), // 西山区劳动就业服务局
    guandu(4, "官渡区劳动就业服务局"), // 官渡区劳动就业服务局
    ;

    private int value;
    private String name;

    private LaborBureauEnum(int value, String name) {
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
