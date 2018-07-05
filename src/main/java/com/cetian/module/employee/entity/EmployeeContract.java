/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: EmployeeContract.java
 * @date 2018/7/3 15:53
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.employee.entity;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cetian.base.entity.ContractStatusEnum;
import com.cetian.base.entity.IdEntity;

/**
 * @ClassName: EmployeeContract
 * @Description: 员工合同
 * @date 2018/7/3 15:53
 * @author zangrong
 */
public class EmployeeContract extends IdEntity {

    private String no;//合同编号
    private Long employeeId;// 员工id
    private Long companyId;// 派遣公司id
    private String department;// 部门
    private String title;// 岗位
    private double salary;// 工资
    private double base;// 基数
    @Enumerated(EnumType.ORDINAL)
    private EmployeeContractTypeEnum type;// 合同类型
    @Enumerated(EnumType.ORDINAL)
    private ContractStatusEnum status;// 合同状态

    private Date start;// 开始时间

    private Date end;// 结束时间

    private Date actualEnd;// 实际结束时间，主要解决终止的情况

}
