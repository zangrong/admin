/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: PictureNewsService.java 
 * @date 2018年4月7日 上午10:00:20 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.module.cms.dao.PictureNewsDao;

/**
 * @ClassName:  PictureNewsService   
 * @Description:TODO
 * @date:  2018年4月7日 上午10:00:20
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class PictureNewsService {
	
	private static final Logger log = LoggerFactory.getLogger(PictureNewsService.class);

	@Autowired
	private PictureNewsDao pictureNewsDao;
}
