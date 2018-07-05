/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: CompanyTypeEnum.java
 * @date 2018/7/3 14:09
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.company.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: CompanyTypeEnum
 * @Description: 公司类型
 * @date 2018/7/3 14:09
 * @author zangrong
 */
public enum CompanyTypeEnum {

    other(0, "其他"), // 其他
    comprehensiveOwnership(1, "合资"),// 合资
    corporateOwnership(2, "独资"),// 独资
    stateOwnership(3, "国有"),// 国有
    privateOwnership(4, "私营"),// 私营
    ;

    private int value;
    private String name;

    private CompanyTypeEnum(int value, String name) {
        // 必须是private的，否则编译错误
        this.value = value;
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
