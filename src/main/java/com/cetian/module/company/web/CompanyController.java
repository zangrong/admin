/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: CompanyController.java
 * @date 2018/7/3 14:04
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.company.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.company.entity.Company;
import com.cetian.module.company.service.CompanyService;

/**
 * @ClassName: CompanyController
 * @Description: TODO
 * @date 2018/7/3 14:04
 * @author zangrong
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public String list(Model model, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize) {
        ResponseMessage responseMessage = companyService.list(pageNo - 1, pageSize);
        model.addAllAttributes(responseMessage.getData());
        return "view/company/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "view/company/create";
    }

    @PostMapping("/create")
    public String create(Model model, Company company) {
        ResponseMessage responseMessage = companyService.create(company);
        // TODO 消息提示问题
        return "redirect:/company";
    }

    @GetMapping("/update")
    public String update(Model model, Long id) {
        log.warn("update id[{}]", id);
        Company company = companyService.get(id);
        model.addAttribute("company", company);
        return "view/company/update";
    }

    @PostMapping("/update")
    public String update(Model model, Company company) {
        log.warn("update id[{}]", company.getId());
        ResponseMessage responseMessage = companyService.update(company);
        model.addAttribute("company", company);
        return "view/company/update";
    }
}
