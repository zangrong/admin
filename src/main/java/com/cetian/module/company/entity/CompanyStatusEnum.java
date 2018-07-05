/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: CompanyStatusEnum.java
 * @date 2018/7/3 14:26
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.company.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: CompanyStatusEnum
 * @Description: 公司状态
 * @date 2018/7/3 14:26
 * @author zangrong
 */
public enum CompanyStatusEnum {

    delete(0), // 删除(删除就是根本不显示)
    active(1),// 有效(有效合同)
    inactive(2),// 无效(无合同或合同已过期)
    ;

    private int value;

    private CompanyStatusEnum(int value) {
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
