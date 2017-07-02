package com.hzlwyykj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzlwyykj.dao.DeptMapper;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Dept;
import com.hzlwyykj.service.IDeptService;

@Service
public class DeptServiceImpl implements IDeptService {
	@Resource
	private DeptMapper deptDao;
	//查询所有数据，带分页和关键字查询,需获取分页的页码和每页大小
	@Override
	public PageInfo<Dept> query(BaseVo vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Dept> depts = deptDao.query(vo);
		PageInfo<Dept> pageInfo = new PageInfo<>(depts);
		return pageInfo;
	}
	//新增部门调用dao中插入不允许为空的方法
	@Override
	public void save(Dept dept) throws RuntimeException {
		deptDao.insertSelective(dept);
	}
	//更新部门
	@Override
	public void update(Dept dept) throws RuntimeException {
		deptDao.updateByPrimaryKey(dept);
	}
	//删除部门
	@Override
	public void delete(int id) {
		deptDao.deleteByPrimaryKey(id);
	}
	//查询所有数据
	@Override
	public List<Dept> queryAll() {
		return deptDao.queryAll();
	}
	//根据主键查询部门
	@Override
	public Dept findById(Integer id) {
		return deptDao.selectByPrimaryKey(id);
	}

}
