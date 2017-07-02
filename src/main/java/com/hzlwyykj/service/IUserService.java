package com.hzlwyykj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.User;

public interface IUserService {
	public List<User> getAllUser();

	public User findByUserName(String username, String password);
	
	//查询带分页和关键字
	PageInfo<User> query(BaseVo vo);
	
	//新增
	void save(User user)throws RuntimeException;
	//更新
	void update(User user)throws RuntimeException;
	//根据主键查询用户
	User findById(int id);
	//删除
	void deleteById(int id)throws RuntimeException;
}
