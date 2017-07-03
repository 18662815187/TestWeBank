package com.hzlwyykj.dao;

import java.util.List;

import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Menu;

public interface MenuMapper {
	int deleteByPrimaryKey(Integer mid);

	int insert(Menu record);

	int insertSelective(Menu record);

	Menu selectByPrimaryKey(Integer mid);

	int updateByPrimaryKeySelective(Menu record);

	int updateByPrimaryKey(Menu record);

	List<Menu> getAll();

	// 列表页数据带分页和关键字检索
	List<Menu> query(BaseVo vo);

}