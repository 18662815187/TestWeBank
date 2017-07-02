package com.hzlwyykj.dao;

import java.util.List;

import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Dept;

public interface DeptMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Dept record);

	int insertSelective(Dept record);

	Dept selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Dept record);

	int updateByPrimaryKey(Dept record);

	List<Dept> queryAll();

	List<Dept> query(BaseVo vo);
}