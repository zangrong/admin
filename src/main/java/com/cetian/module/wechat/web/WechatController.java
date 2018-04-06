/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: WechatController.java 
 * @date 2018年3月30日 下午5:16:14 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.wechat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName:  WechatController   
 * @Description: 与微信系统交互对接用
 * @date:  2018年3月30日 下午5:16:14
 * @author: zangrong
 * 
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {

	
	@GetMapping("/test")
	public String random() {
		// 如果第一次访问，随机生成一套题，方便进行测试
		return "view/wechat/test";
	}
}
