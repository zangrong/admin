/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: CompanyService.java
 * @date 2018/7/3 23:27
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.company.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.company.dao.CompanyDao;
import com.cetian.module.company.entity.Company;

/**
 * @ClassName: CompanyService
 * @Description: 公司信息
 * @date 2018/7/3 23:27
 * @author zangrong
 */
@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public ResponseMessage list(int pageNo, int pageSize) {
        ResponseMessage responseMessage = new ResponseMessage();
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.Direction.DESC, "id");
        Page<Company> page = companyDao.findAll(pageRequest);
        responseMessage.put(page);
        responseMessage.success();
        return responseMessage;
    }

    public ResponseMessage create(Company company){
        ResponseMessage responseMessage = new ResponseMessage();
        // TODO 重名校验

        company.setCreateDate(new Date());
        company.setUpdateDate(new Date());
        companyDao.save(company);
        responseMessage.success();
        return responseMessage;
    }

    public Company get(Long id) {
        Optional<Company> optional = companyDao.findById(id);
        return optional.get();
    }

    public ResponseMessage update(Company company) {
        ResponseMessage responseMessage = new ResponseMessage();
        Optional<Company> optional = companyDao.findById(company.getId());
        if (!optional.isPresent()) {
            responseMessage.setMessage("公司未找到");
            return responseMessage;
        }
        Company exist = optional.get();
        exist.setCode(company.getCode());
        exist.setName(company.getName());
        exist.setRemark(company.getRemark());
        exist.setType(company.getType());
        exist.setAccountable(company.isAccountable());
        exist.setAddress(company.getAddress());
        exist.setContact(company.getContact());
        exist.setCorporationId(company.getCorporationId());
        exist.setPhone(company.getPhone());
        companyDao.save(exist);
        responseMessage.success();
        return responseMessage;
    }
}
