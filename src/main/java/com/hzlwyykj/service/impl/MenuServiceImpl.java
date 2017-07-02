package com.hzlwyykj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hzlwyykj.dao.MenuMapper;
import com.hzlwyykj.model.Menu;
import com.hzlwyykj.service.IMenuService;
@Service
public class MenuServiceImpl implements IMenuService{
	@Resource
	private MenuMapper menuDao;
	//获取所有权限菜单
	@Override
	public List<Menu> getAll() {
		return menuDao.getAll();
	}
}
