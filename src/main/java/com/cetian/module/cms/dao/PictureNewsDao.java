/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: PictureNewsDao.java 
 * @date 2018年4月7日 上午9:58:02 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.cms.entity.PictureNews;

/**
 * @ClassName:  PictureNewsDao   
 * @Description:TODO
 * @date:  2018年4月7日 上午9:58:02
 * @author: zangrong
 * 
 */
public interface PictureNewsDao extends PagingAndSortingRepository<PictureNews, Long>, JpaSpecificationExecutor<PictureNews> {

}
