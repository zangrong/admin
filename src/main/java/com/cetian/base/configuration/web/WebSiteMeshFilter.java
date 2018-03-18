/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: WebSiteMeshFilter.java 
 * @date 2017年9月5日 上午9:27:45 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * @ClassName: WebSiteMeshFilter
 * @Description: sitemesh 过滤器
 * @date: 2017年9月5日 上午9:27:45
 * @author: zangrong
 * 
 */
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	
	private static final String TEMPLATE_MAIN = "/WEB-INF/layout/template.jsp";
	private static final String TEMPLATE_LOGIN = "/WEB-INF/layout/templateLogin.jsp";
	private static final String TEMPLATE_INDEX = "/WEB-INF/layout/templateIndex.jsp";

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		// 模板应用
		builder.addDecoratorPath("/index*", TEMPLATE_INDEX);
		builder.addDecoratorPath("/home*", TEMPLATE_MAIN);
		builder.addDecoratorPath("/login*", TEMPLATE_LOGIN);
		
		
		// 过滤，不使用模板
		builder.addExcludedPath("/static/*")
				.addExcludedPath("/app*");

		// 自定义标签
		builder.addTagRuleBundle(new ExpandTagRuleBundle());
	}
}
