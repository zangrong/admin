/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: BaseCache.java 
 * @date 2018年3月1日 下午1:32:54 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.cetian.base.configuration.cache.RedisConfiguration1;

/**
 * @ClassName: BaseCache
 * @Description: 缓存基础类
 * @date: 2018年3月1日 下午1:32:54
 * @author: zangrong
 * 
 */
@Service
public class BaseCache {
	
	@Autowired
	@Qualifier(RedisConfiguration1.REDIS1_0)
	protected RedisTemplate<Object, Object> redis1_0;

	@Autowired
	@Qualifier(RedisConfiguration1.REDIS1_1)
	protected RedisTemplate<Object, Object> redis1_1;

}
