/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CtInvocationSecurityMetadataSourceService.java 
 * @date 2018年3月13日 下午5:19:54 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import com.cetian.module.system.dao.PermissionDao;
import com.cetian.module.system.dao.RoleDao;
import com.cetian.module.system.entity.Permission;
import com.cetian.module.system.entity.Role;

/**
 * @ClassName: CtInvocationSecurityMetadataSourceService
 * @Description: 动态权限控制
 * @date: 2018年3月13日 下午5:19:54
 * @author: zangrong
 * 
 */
@Service
public class CtInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
	
	private static final Logger log = LoggerFactory.getLogger(CtInvocationSecurityMetadataSourceService.class);

	@Autowired
    private PermissionDao permissionDao;
	
	@Autowired
	private RoleDao roleDao;
	
	// key:访问路径path 例如(/system)生成的matcher，value: ConfigAttribute集合 例如(ROLE_ADMIN, PER_SYSTEM_A)
    private Map<AntPathRequestMatcher, Collection<ConfigAttribute>> map = new HashMap<>();
    
    private Collection<ConfigAttribute> allConfigs = new HashSet<>();
    
    @PostConstruct
    public void init() {
    		// 启动时加载
    		load();
    }
	
    /**
     * 加载权限配置
     * 权限配置修改后需要重新加载
     * ConfigAttribute 实际对应role的值
     */
    public void load(){
		// role : permission 多对多
		Iterable<Role> roles = roleDao.findAll();
		Iterable<Permission> permissions = permissionDao.findAll();
		Map<String, List<String>> permissionRoleMap = new HashMap<>();
		for (Permission permission : permissions) {
			String permissionValue = permission.getValue();
			List<String> roleValues = permissionRoleMap.get(permissionValue);
			if (roleValues == null) {
				roleValues = new ArrayList<>();
				permissionRoleMap.put(permissionValue, roleValues);
			}
			for (Role role : roles) {
				if (role.hasPermission(permissionValue)) {
					roleValues.add(role.getValue());
				}
			}
		}
        
        // key: 根据 permission.path 生成访问路径校验 matcher
        // value: 根据 role.value 生成ConfigAttribute的集合作为 value
        for(Permission permission : permissions) {
        		// path为空的权限不做匹配校验
        		if (StringUtils.isBlank(permission.getPath())) {
				continue;
			}
        		AntPathRequestMatcher matcher = new AntPathRequestMatcher(permission.getPath());
        		String permissionValue = permission.getValue();
        		List<String> roleValues = permissionRoleMap.get(permissionValue);
        		Collection<ConfigAttribute> configs = new ArrayList<>();
			for (String roleValue : roleValues) {
				ConfigAttribute config = new SecurityConfig("ROLE_"+roleValue);
				configs.add(config);
			}
            map.put(matcher, configs);
        }

    }
	
    /**
     * 此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
     */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// object 中包含用户请求的request 信息
		HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
		String requestURI = request.getRequestURI();
		// 登录后默认 /home 放行
		if (StringUtils.startsWith(requestURI, "/home")) {
			return null;
		}
		for (Entry<AntPathRequestMatcher, Collection<ConfigAttribute>> entry : map.entrySet()) {
			if (entry.getKey().matches(request)) {
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
