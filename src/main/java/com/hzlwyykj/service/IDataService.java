package com.hzlwyykj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Data;

public interface IDataService {
	// 查询带分页、关键字检索
	PageInfo<Data> query(BaseVo vo);

	// 查询所有
	List<Data> getAll();

	// 保存
	void save(Data data) throws RuntimeException;

	// 删除
	void delete(int id) throws RuntimeException;

	// 更新
	void update(Data data) throws RuntimeException;

	// 根据主键查询
	Data findById(int id);
}
