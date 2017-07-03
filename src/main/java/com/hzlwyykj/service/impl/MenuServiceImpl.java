package com.hzlwyykj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzlwyykj.dao.MenuMapper;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Menu;
import com.hzlwyykj.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {
	@Resource
	private MenuMapper menuDao;

	// 获取所有权限菜单
	@Override
	public List<Menu> getAll() {
		return menuDao.getAll();
	}

	// 带分页和关键字的列表页
	@Override
	public PageInfo<Menu> query(BaseVo vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Menu> menus = menuDao.query(vo);
		PageInfo<Menu> pageInfo = new PageInfo<>(menus);
		return pageInfo;
	}

	// 新增
	@Override
	public void save(Menu menu) throws RuntimeException {
		menuDao.insertSelective(menu);
	}

	// 更新
	@Override
	public void update(Menu menu) throws RuntimeException {
		menuDao.updateByPrimaryKey(menu);
	}

	// 根据主键查询
	@Override
	public Menu findById(Integer id) {
		return menuDao.selectByPrimaryKey(id);
	}
	//删除
	@Override
	public void deleteById(Integer id) {
		menuDao.deleteByPrimaryKey(id);
	}
}
