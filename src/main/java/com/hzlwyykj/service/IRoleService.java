package com.hzlwyykj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Role;

public interface IRoleService {
	// 查询所有带分页关键字查询
	PageInfo<Role> query(BaseVo vo);
	// 查询所有
	List<Role> queryAll();
	//保存role表数据
	void save(Role role)throws RuntimeException;
	//更新
	void update(Role role)throws RuntimeException;
	//根据主键查询
	Role findRoleById(Integer id);
	//删除
	void deleteById(Integer id)throws RuntimeException;
}
