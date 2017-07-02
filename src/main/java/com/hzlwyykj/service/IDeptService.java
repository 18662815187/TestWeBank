package com.hzlwyykj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Dept;

public interface IDeptService {
	//查询所有数据带分页和关键字查询
	PageInfo<Dept> query(BaseVo vo);
	//新增部门
	void save(Dept dept) throws RuntimeException;
	//更新部门
	void update(Dept dept) throws RuntimeException;
	//删除部门
	void delete(int id);
	//查询所有
	List<Dept> queryAll();
	//根据主键查询部门
	Dept findById(Integer id);

}
