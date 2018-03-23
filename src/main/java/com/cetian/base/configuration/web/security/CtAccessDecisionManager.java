/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CtAccessDecisionManager.java 
 * @date 2018年3月13日 下午4:07:00 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web.security;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * @ClassName:  CtAccessDecisionManager   
 * @Description: 访问判定器，用于判定一个管理员是否有访问某个路径的权限
 * @date:  2018年3月13日 下午4:07:00
 * @author: zangrong
 * 
 */
@Service
public class CtAccessDecisionManager implements AccessDecisionManager{
	
	private static final Logger log = LoggerFactory.getLogger(CtAccessDecisionManager.class);

	/* (non-Javadoc)
	 * @see org.springframework.security.access.AccessDecisionManager#decide(org.springframework.security.core.Authentication, java.lang.Object, java.util.Collection)
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (CollectionUtils.isEmpty(configAttributes)) {
			return;
		}
		for (ConfigAttribute config : configAttributes) {
			String needRole = config.getAttribute();
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (StringUtils.equals(needRole, ga.getAuthority())) {
					return;
				}
			}
		}
		log.warn("管理员[{}] 访问未授权", authentication.getPrincipal());
		throw new AccessDeniedException("no right");
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.AccessDecisionManager#supports(org.springframework.security.access.ConfigAttribute)
	 */
	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.AccessDecisionManager#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
