package com.hzlwyykj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Menu;

public interface IMenuService {
	//查询所有
	List<Menu> getAll();
	//列表页带分页和关键词查询
	PageInfo<Menu> query(BaseVo vo);
}
