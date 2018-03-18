/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved. 
 * @Title: CtFilterSecurityInterceptor.java 
 * @date 2018年3月13日 下午5:14:41 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

/**
 * @ClassName:  CtFilterSecurityInterceptor   
 * @Description:TODO
 * @date:  2018年3月13日 下午5:14:41
 * @author: zangrong
 * 
 */
@Service
public class CtFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{
	
	private static final Logger log = LoggerFactory.getLogger(CtFilterSecurityInterceptor.class);

	@Autowired
    private CtInvocationSecurityMetadataSourceService ctInvocationSecurityMetadataSourceService;
	
	@Autowired
	public void setCtAccessDecisionManager(CtAccessDecisionManager ctAccessDecisionManager) {
		super.setAccessDecisionManager(ctAccessDecisionManager);
	}
	
	@Override
	public void destroy() {
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("CtFilterSecurityInterceptor init");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
	}

	public void invoke(FilterInvocation fi) throws IOException, ServletException {
		// fi里面有一个被拦截的url
		// 里面调用ctInvocationSecurityMetadataSourceService的getAttributes(Object
		// object)这个方法获取fi对应的所有权限
		// 再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			// 执行下一个拦截器
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.access.intercept.AbstractSecurityInterceptor#getSecureObjectClass()
	 */
	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.intercept.AbstractSecurityInterceptor#obtainSecurityMetadataSource()
	 */
	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.ctInvocationSecurityMetadataSourceService;
	}

}
