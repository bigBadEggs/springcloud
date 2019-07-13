package com.ithm.microcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ithm.entity.Dept;
import com.ithm.microcloud.dao.DeptDao;
import com.ithm.microcloud.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;

	@Override
	public Dept get(long id) {
		return this.deptDao.getById(id);
	}

	@Override
	@Transactional
	public boolean add(Dept po) {
		return this.deptDao.doCreate(po);
	}

	@Override
	public List<Dept> list() {
		return this.deptDao.findAll();
	}

}
