/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: Resume.java
 * @date 2018/7/3 17:12
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.employee.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName: Resume
 * @Description: 员工简历
 * @date 2018/7/3 17:12
 * @author zangrong
 */
@Entity
@Table(name = "ct_hr_resume")
public class Resume extends IdEntity {

    private Long employeeId;// 员工id
    private Long companyId;// 公司id
    private String companyName;// 公司名称
    private String title;// 岗位
    private Date start;// 开始时间
    private Date end;// 结束时间
    private String remark;// 备注

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
