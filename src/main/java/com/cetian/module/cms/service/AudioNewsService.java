/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AudioNewsService.java 
 * @date 2018年4月7日 上午10:00:44 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.module.cms.dao.AudioNewsDao;

/**
 * @ClassName:  AudioNewsService   
 * @Description:TODO
 * @date:  2018年4月7日 上午10:00:44
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class AudioNewsService {
	
	private static final Logger log = LoggerFactory.getLogger(AudioNewsService.class);
	
	@Autowired
	private AudioNewsDao audioNewsDao;
}
