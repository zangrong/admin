/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: EducationEnum.java
 * @date 2018/7/3 14:38
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.employee.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: EducationEnum
 * @Description: 教育程度
 * @date 2018/7/3 14:38
 * @author zangrong
 */
public enum EducationEnum {

    unknown(0, "未知"), // 未知
    primarySchool(1, "小学"),// 小学
    juniorHighSchool(2, "初中"),// 初中
    highSchool(3, "高中"),// 高中
    vocationalCollege(4, "高职"),// 高职
    college(5, "大专"),// 大专
    university(6, "本科"),// 本科
    postgraduate(7, "研究生"),// 研究生
    doctor(8, "博士"),// 博士
    ;

    private String name;
    private int value;

    private EducationEnum(int value, String name) {
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
