/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: FilterConfiguration.java 
 * @date 2017年3月3日 下午2:07:26 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web;

import java.io.IOException;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @ClassName: WebConfiguration
 * @Description: Web相关配置，过滤器配置，freemarker路径配置
 * @date: 2017年3月3日 下午2:07:26
 * @author: zangrong
 * 
 */
@Configuration
public class WebConfiguration {

	/**
	 * 装饰器
	 * 
	 */
	@Bean
	public FilterRegistrationBean<WebSiteMeshFilter> siteMeshFilter() {
		FilterRegistrationBean<WebSiteMeshFilter> fitler = new FilterRegistrationBean<>();
		WebSiteMeshFilter siteMeshFilter = new WebSiteMeshFilter();
		fitler.setFilter(siteMeshFilter);
		return fitler;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				String[] methods = { "GET", "POST", "OPTIONS", "DELETE" };
				registry.addMapping("/**").allowCredentials(true).allowedMethods(methods);
			}

			// setUseSuffixPatternMatch :
			// 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；
			// setUseTrailingSlashMatch :
			// 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
			@Override
			public void configurePathMatch(PathMatchConfigurer configurer) {
				configurer.setUseSuffixPatternMatch(false).setUseTrailingSlashMatch(false);
			}

			// @Override
			// public void addResourceHandlers(ResourceHandlerRegistry registry) {
			// registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
			// super.addResourceHandlers(registry);
			// }

		};
	}

	/**
	 * 
	 * @Title: customizer
	 * @Description: 解决异常向cookie添加json字符串时产生的异常[An invalid character [34] was
	 *               present in the Cookie value]<br>
	 *               http://stackoverflow.com/questions/38687210/error-with-cookie-value-when-adding-a-new-spring-session<br>
	 *               This is due to Tomcat's cookie processing being changed to a
	 *               RFC 6265 compliant implementation by default in 8.5, which does
	 *               not allow space (character 32), among others.
	 * 
	 *               As a workaround, you can configure Tomcat to use legacy cookie
	 *               processor. To do this with Spring Boot, register an
	 *               EmbeddedServletContainerCustomizer @Bean like this:
	 * @return
	 * @return: EmbeddedServletContainerCustomizer
	 * @throws:
	 */
//	@Bean
//	public EmbeddedServletContainerCustomizer customizer() {
//		return container -> {
//			if (container instanceof TomcatEmbeddedServletContainerFactory) {
//				TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
//				tomcat.addContextCustomizers(context -> context.setCookieProcessor(new LegacyCookieProcessor()));
//			}
//		};
//	}

	@Bean(name = "objectMapper")
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
					throws IOException, JsonProcessingException {
				gen.writeString("");
			}
		});
		return objectMapper;
	}
}
