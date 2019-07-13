package com.ithm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ithm.entity.Dept;
import com.ithm.microcloud.Dept_8001_StartSpringCloudApplication;
import com.ithm.microcloud.service.DeptService;

@SpringBootTest(classes = Dept_8001_StartSpringCloudApplication.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class DeptServiceTest {

	@Autowired
	private DeptService deptService;

	@Test
	public void testGet() {
		System.out.println(this.deptService.get(1));
	}

	@Test
	public void testAdd() {
		Dept po = new Dept();
		po.setDname("测试部-" + System.currentTimeMillis());
		System.out.println(this.deptService.add(po));
	}

	@Test
	public void testList() {
		System.out.println(this.deptService.list());
	}

}
