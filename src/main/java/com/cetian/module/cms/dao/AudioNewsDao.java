/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: AudioNewsDao.java 
 * @date 2018年4月7日 上午9:58:39 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.cms.entity.AudioNews;

/**
 * @ClassName:  AudioNewsDao   
 * @Description:TODO
 * @date:  2018年4月7日 上午9:58:39
 * @author: zangrong
 * 
 */
public interface AudioNewsDao extends PagingAndSortingRepository<AudioNews, Long>, JpaSpecificationExecutor<AudioNews> {

}
