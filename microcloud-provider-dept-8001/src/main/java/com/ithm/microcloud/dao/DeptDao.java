package com.ithm.microcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ithm.entity.Dept;

@Mapper
public interface DeptDao {

	public boolean doCreate(Dept po);

	public Dept getById(long id);

	public List<Dept> findAll();
}
