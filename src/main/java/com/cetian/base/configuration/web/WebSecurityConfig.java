/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: WebSecurityConfig.java 
 * @date 2018年3月1日 下午1:15:59 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.cetian.base.configuration.web.security.CtFilterSecurityInterceptor;
import com.cetian.base.configuration.web.security.CtUserDetailsService;

/**
 * @ClassName: WebSecurityConfig
 * @Description:TODO
 * @date: 2018年3月1日 下午1:15:59
 * @author: zangrong
 * 
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CtFilterSecurityInterceptor ctFilterSecurityInterceptor;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		http.authorizeRequests().antMatchers("/", "/app/**", "/static/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/home", true).permitAll()
			.and()
			.logout().invalidateHttpSession(true).permitAll();
		// 系统自定义权限校验
		http.addFilterBefore(ctFilterSecurityInterceptor, FilterSecurityInterceptor.class);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
	
	
	@Bean
	public UserDetailsService customUserDetailsService() {
		return new CtUserDetailsService();
	};

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("123")).roles("USER");
		auth.userDetailsService(customUserDetailsService());
	}
}
