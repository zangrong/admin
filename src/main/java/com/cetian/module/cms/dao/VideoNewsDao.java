/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: VideoNewsDao.java 
 * @date 2018年4月7日 上午9:58:22 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.cms.entity.VideoNews;

/**
 * @ClassName:  VideoNewsDao   
 * @Description:TODO
 * @date:  2018年4月7日 上午9:58:22
 * @author: zangrong
 * 
 */
public interface VideoNewsDao extends PagingAndSortingRepository<VideoNews, Long>, JpaSpecificationExecutor<VideoNews> {

}
