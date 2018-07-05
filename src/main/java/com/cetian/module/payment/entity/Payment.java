/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: Payment.java
 * @date 2018/7/3 16:53
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.payment.entity;

import java.util.Date;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName: Payment
 * @Description: 缴费
 * @date 2018/7/3 16:53
 * @author zangrong
 */
public class Payment extends IdEntity {

    private Long employeeId;// 员工id
    private int year;// 年份
    private int month;// 月份 1-12
    private PaymentStatusEnum status;// 缴费状态
    private double base;// 缴费基数
    private double salary;// 工资
    private double pension;// 养老保险
    private double pensionRate;// 养老保险缴费比例
    private double pensionAdd;// 养老保险补缴
    private double medical;// 医疗保险
    private double medicalRate; // 医疗保险缴费比例
    private double medicalAdd;// 医疗保险补缴
    private double unemployment;//失业保险
    private double unemploymentRate;//失业保险缴费比例
    private double unemploymentAdd;//失业保险补缴
    private double injury;// 工伤
    private double injuryRate;// 工伤缴费比例
    private double injuryAdd;// 工伤补缴
    private double providentFund;// 公积金
    private double providentFundRate;// 公积金缴费比例
    private double providentFundAdd;// 公积金补缴

    private Date payDate;// 缴费日期

}
