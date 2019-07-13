package com.ithm.microcloud.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Resource
	public void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
		// 添加用户认证和授权角色 (此处添加bigBadEgg, admin俩用户)
		auth.inMemoryAuthentication().withUser("bigBadEgg").password("123")
			.roles("USER")
			.and().withUser("admin").password("admin123").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 启用SpringSecurity安全配置项 -- 表示所有访问都必须认证处理
		http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
		// 所有Rest服务必须设置为无状态，以提升操作性能
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
}
