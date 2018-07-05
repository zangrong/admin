/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: CompanyContract.java
 * @date 2018/7/3 16:15
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.company.entity;

import java.util.Date;

import com.cetian.base.entity.ContractStatusEnum;
import com.cetian.base.entity.IdEntity;
import com.cetian.base.entity.PeriodEnum;

/**
 * @ClassName: CompanyContract
 * @Description: 公司合同
 * @date 2018/7/3 16:15
 * @author zangrong
 */
public class CompanyContract extends IdEntity {

    private String no;// 合同编号
    private Long companyId;
    private PeriodEnum period;// 结算周期
    private ContractStatusEnum status;// 合同状态
    private double serviceFee;// 单人次服务费
    private Date start;// 合同开始时间
    private Date end;// 合同结束时间
    private String remark;
}
