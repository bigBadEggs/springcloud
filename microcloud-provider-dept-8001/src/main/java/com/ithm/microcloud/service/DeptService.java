package com.ithm.microcloud.service;

import java.util.List;

import com.ithm.entity.Dept;

public interface DeptService {

	public Dept get(long id);

	public boolean add(Dept po);

	public List<Dept> list();
}
