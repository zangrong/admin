/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: UploadService.java 
 * @date 2018年4月13日 下午1:49:21 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cetian.base.service.QiniuService;

/**
 * @ClassName:  UploadService   
 * @Description:TODO
 * @date:  2018年4月13日 下午1:49:21
 * @author: zangrong
 * 
 */
@Service
public class UploadService {
	
	@Autowired
	private QiniuService qiniuService;

	public String image(MultipartFile file) {
		String url = qiniuService.upload(file);
		return url;
	}
	
}
