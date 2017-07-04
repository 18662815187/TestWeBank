package com.hzlwyykj.dao;

import java.util.List;

import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Data;

public interface DataMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Data record);

	int insertSelective(Data record);

	Data selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Data record);

	int updateByPrimaryKey(Data record);

	// 列表页带分页和关键字检索
	List<Data> query(BaseVo vo);

	// 查询所有
	List<Data> getAll();
}