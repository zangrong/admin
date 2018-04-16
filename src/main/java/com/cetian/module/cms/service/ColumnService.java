/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ColumnService.java 
 * @date 2018年4月16日 上午10:51:04 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.cms.dao.ColumnDao;
import com.cetian.module.cms.entity.Column;

/**
 * @ClassName:  ColumnService   
 * @Description:TODO
 * @date:  2018年4月16日 上午10:51:04
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class ColumnService {
	
	@Autowired
	private ColumnDao columnDao;
	
	public ResponseMessage create(Column column) {
		ResponseMessage responseMessage = new ResponseMessage();
		column.setEnable(true);
		columnDao.save(column);
		
		responseMessage.success();
		return responseMessage;
	}

	/**
	 * @Title: all   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @return: List<Column>      
	 * @throws: 
	 */
	public List<Column> all() {
		return (List<Column>) columnDao.findAll(new Sort(Direction.ASC, "id"));
	}
	
	public ResponseMessage update(Column column) {
		ResponseMessage responseMessage = new ResponseMessage();
		Optional<Column> optional = columnDao.findById(column.getId());
		if (!optional.isPresent()) {
			responseMessage.setMessage("栏目不存在");
			return responseMessage;
		}
		// TODO 重名检查之类
		Column exist = optional.get();
		exist.setName(column.getName());
		exist.setRemark(column.getRemark());
		columnDao.save(exist);
		
		responseMessage.success();
		return responseMessage;
	}

	/**
	 * @Title: get   
	 * @Description: 
	 * @param id
	 * @return: Column      
	 * @throws: 
	 */
	public Column get(Long id) {
		return columnDao.findById(id).get();
	}
	
}
