/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: Company.java
 * @date 2018/7/3 14:03
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.company.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.cetian.base.entity.IdEntity;

/**
 * @ClassName: Company
 * @Description: 公司
 * @date 2018/7/3 14:03
 * @author zangrong
 */
@Entity
@Table(name = "ct_hr_company")
public class Company extends IdEntity {

    private String no;// 公司编号
    private String name;// 公司名称
    @Enumerated(EnumType.ORDINAL)
    private CompanyStatusEnum status; // 公司状态
    @Enumerated(EnumType.ORDINAL)
    private CompanyTypeEnum type;// 公司类型
    private String code;// 社会统一信用代码
    private String license;// 营业执照照片
    private String address;// 地址
    private String contact;// 联系人
    private String phone;// 联系电话
    private Long laborBureauId;// 所属就业局id
    private Long parentId;// 上级公司id，可以为空
    private boolean accountable;// 是否可以独立结算(有分子公司情况，是由总公司统一结算)
    @Type(type = IdEntity.JSON)
    private List<String> departments;
    private String corporationName;// 法人姓名
    private String corporationId;// 法人身份证号
    private int employeeCount;// 员工数


    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间
    private String remark;// 备注信息

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CompanyStatusEnum status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public boolean isAccountable() {
        return accountable;
    }

    public void setAccountable(boolean accountable) {
        this.accountable = accountable;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    public CompanyTypeEnum getType() {
        return type;
    }

    public void setType(CompanyTypeEnum type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getLaborBureauId() {
        return laborBureauId;
    }

    public void setLaborBureauId(Long laborBureauId) {
        this.laborBureauId = laborBureauId;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
}
