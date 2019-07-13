package com.ithm.microcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ithm.entity.Dept;

@RestController
public class ConsumerDeptController {

	// 服务地址
	private static final String DEPT_GET_URL = "http://localhost:8001/dept/get/";
	private static final String DEPT_LIST_URL = "http://localhost:8001/dept/list/";
	private static final String DEPT_ADD_URL = "http://localhost:8001/dept/add/";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HttpHeaders headers;

	@RequestMapping(value = "/consumer/dept/get")
	public Dept get(long id) {
		return restTemplate
				.exchange(DEPT_GET_URL + id, HttpMethod.GET, 
						new HttpEntity<Object>(headers), Dept.class)
				.getBody();
		
//		return restTemplate.getForObject(DEPT_GET_URL + id, Dept.class);
	}

	@RequestMapping(value = "/consumer/dept/add")
	public Boolean add(Dept dept) {
		/* exchange(url, method, requestEntity, responseType)
		 * url: 访问路径信息
		 * method: 操作模式（get/post）
		 * requestEntity: 传递头信息
		 *		new HttpEntity<T>(body, headers): body传递参数
		 * responseType: 返回类型
		 */
		return restTemplate
				.exchange(DEPT_ADD_URL, HttpMethod.POST, 
						new HttpEntity<Object>(dept, headers), Boolean.class)
				.getBody();
		
		/* postForObject(url, request, responseType) 
		 * url：访问路径
		 * request: 传递参数 
		 * responseType：返回值结果
		 */
//		return restTemplate.postForObject(DEPT_ADD_URL, dept, Boolean.class);
	}
	
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.exchange(DEPT_LIST_URL, HttpMethod.GET, 
				new HttpEntity<Object>(headers), List.class).getBody();
		
//		List<Dept> list = restTemplate.getForObject(DEPT_LIST_URL, List.class);
//		return list;
	}
}
