package com.ithm.microcloud.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ithm.entity.Dept;
import com.ithm.microcloud.service.DeptService;

@RestController
public class DeptRest {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/dept/sessionId")
	public Object id(HttpServletRequest request){
		return request.getSession().getId();
	}

	@RequestMapping(value = "/dept/get/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public Dept get(@PathVariable("id") long id) {
		return this.deptService.get(id);
	}

	@RequestMapping(value = "/dept/getById", method = { RequestMethod.GET, RequestMethod.POST })
	public Dept getById(HttpServletRequest request, HttpServletResponse response) {
		String str_id = request.getParameter("id");
		long id = Long.parseLong(str_id);
		return this.deptService.get(id);
	}

	@RequestMapping(value = "/dept/add", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean add(@RequestBody Dept po) {
		return this.deptService.add(po);
	}

	@RequestMapping(value = "/dept/list", method = { RequestMethod.GET, RequestMethod.POST })
	public List<Dept> get() {
		return this.deptService.list();
	}

}
