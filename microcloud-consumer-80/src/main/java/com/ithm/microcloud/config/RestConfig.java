package com.ithm.microcloud.config;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration // 声明这是一个配置类
public class RestConfig {

	// 进行http的头信息配置
	@Bean
	public HttpHeaders getHeaders(){
		// 定义一个Http头信息
		HttpHeaders headers = new HttpHeaders();
		// 认证原始信息
		String auth = "bigBadEgg:123";
		// Base64加密处理
		byte[] encodeAuth = Base64.getEncoder()
				.encode(auth.getBytes(Charset.forName("US-ASCII")));
		// 授权头信息配置 -- Basic与加密信息之间需要空格，否则报错401
		String authHeader = "Basic " + new String(encodeAuth);
		// 返回头信息
		headers.set("Authorization", authHeader);
		return headers;
	}
	
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
