/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: RedisConfiguration1.java 
 * @date 2017年3月15日 上午9:14:00 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.cache;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ClassName: RedisConfiguration1
 * @Description: redis缓存配置
 * @date: 2017年3月15日 上午9:14:00
 * @author: zangrong
 * 
 */
@Configuration
@ConfigurationProperties(prefix = "spring.cache.redis1")
public class RedisConfiguration1 {

	public static final String REDIS1_0 = "redis1_0";// sessionModule List
	public static final String REDIS1_1 = "redis1_1";// 

	private String hostname;
	private int port;
	private String password;
	private String clientName;
	private long readTimeout;
	private long connectTimeout;

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public void setReadTimeout(long readTimeout) {
		this.readTimeout = readTimeout;
	}
	
	public void setConnectTimeout(long connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public JedisConnectionFactory connectionFactory(int index) {
		// 支持三种配置
		RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
		standaloneConfiguration.setHostName(this.hostname);
		standaloneConfiguration.setPort(this.port);
		standaloneConfiguration.setDatabase(index);
		standaloneConfiguration.setPassword(RedisPassword.of(this.password));
		
		JedisClientConfiguration clientConfiguration = JedisClientConfiguration.builder()
			.clientName(this.clientName)
			.readTimeout(Duration.ofSeconds(this.readTimeout))
			.connectTimeout(Duration.ofSeconds(this.connectTimeout))
			.build();
		
		JedisConnectionFactory factory = new JedisConnectionFactory(standaloneConfiguration, clientConfiguration);
		factory.afterPropertiesSet();
		return factory;
	}

	@Bean(name = REDIS1_0)
	public RedisTemplate<Object, Object> redis1_0() {
		return getRedisTemplate(0);
	}

	@Bean(name = REDIS1_1)
	public RedisTemplate<Object, Object> redis1_1() {
		return getRedisTemplate(1);
	}


	private RedisTemplate<Object, Object> getRedisTemplate(Integer dbIndex) {
		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		// 初始化连接，尾数是多少，数字就设置多少
		RedisConnectionFactory factory = connectionFactory(dbIndex);
		template.setConnectionFactory(factory);

		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		// 优点: 反序列化可以完全恢复数据类型 缺点: 存在redis中的json数据不是标准格式，其他语言的程序无法通用
		GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
		
		// 允许使用多种序列化器
//		GenericToStringSerializer<String> genericToStringSerializer = new GenericToStringSerializer<String>(String.class);
		// 标准对象序列化器，优点:可以序列化为标准json格式，方便其他程序使用redis数据，比较通用。缺点:反序列化后是 LinkedHashMap，原有数据类型丢失
//		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
//				Object.class);
//		ObjectMapper om = new ObjectMapper();
//		om.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(stringRedisSerializer);
		template.setValueSerializer(genericJackson2JsonRedisSerializer);
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(genericJackson2JsonRedisSerializer);
		return template;
	}

	/**
	 * 
	 * @Title: getMapRedisTemplate
	 * @Description: value为String的Map专用
	 * @param dbIndex
	 * @return: RedisTemplate<Object,Object>
	 * @throws:
	 */
	private RedisTemplate<Object, Object> getMapRedisTemplate(Integer dbIndex) {
		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		// 初始化连接，尾数是多少，数字就设置多少
		RedisConnectionFactory factory = connectionFactory(dbIndex);
		template.setConnectionFactory(factory);

		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericToStringSerializer<String>(String.class));
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericToStringSerializer<String>(String.class));
		return template;
	}

}
