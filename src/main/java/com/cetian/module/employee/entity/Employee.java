/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: Employee.java
 * @date 2018/7/3 14:05
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.employee.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.cetian.base.entity.GenderEnum;
import com.cetian.base.entity.IdEntity;

/**
 * @ClassName: Employee
 * @Description: 员工信息
 * @date 2018/7/3 14:05
 * @author zangrong
 */
@Entity
@Table(name = "ct_hr_employee")
public class Employee extends IdEntity {

    private String no;// 员工编号
    private String name;// 姓名
    @Enumerated(EnumType.ORDINAL)
    private GenderEnum gender;// 性别
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatusEnum status;// 状态
    @Enumerated(EnumType.ORDINAL)
    private EmployeeTypeEnum type;// 类型
    private String idNumber;// 身份证号
    private String idFront;// 身份证照
    private String nativePlace;// 籍贯
    private String domicile;// 户籍所在地
    private String address;// 住址
    private String phone;//联系电话
    @Enumerated(EnumType.ORDINAL)
    private EducationEnum education;// 学历
    @Type(type = IdEntity.JSON)
    private List<Resume> resumes;// 简历
    private Long companyId;// 所属公司id
    private Long contractId;// 最新一份合同的id

    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间
    private String remark;// 备注

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

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public EmployeeStatusEnum getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatusEnum status) {
        this.status = status;
    }

    public EmployeeTypeEnum getType() {
        return type;
    }

    public void setType(EmployeeTypeEnum type) {
        this.type = type;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdFront() {
        return idFront;
    }

    public void setIdFront(String idFront) {
        this.idFront = idFront;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EducationEnum getEducation() {
        return education;
    }

    public void setEducation(EducationEnum education) {
        this.education = education;
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}
