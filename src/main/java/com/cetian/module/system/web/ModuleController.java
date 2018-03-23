/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ModuleController.java 
 * @date 2018年3月19日 上午10:52:36 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.system.web;

import org.springframework.stereotype.Controller;

/**
 * @ClassName:  ModuleController   
 * @Description:TODO
 * @date:  2018年3月19日 上午10:52:36
 * @author: zangrong
 * 
 */
@Controller
public class ModuleController {
	
	public String list() {
		return "module/list";
	}
	
	public String update() {
		
		return "";
	}
	
}
