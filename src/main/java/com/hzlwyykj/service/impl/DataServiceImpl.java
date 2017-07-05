package com.hzlwyykj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzlwyykj.dao.DataMapper;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Data;
import com.hzlwyykj.service.IDataService;

@Service
public class DataServiceImpl implements IDataService {
	@Resource
	private DataMapper dataDao;

	// 列表页带分页和关键字
	@Override
	public PageInfo<Data> query(BaseVo vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Data> datas = dataDao.query(vo);
		PageInfo<Data> pageInfo = new PageInfo<>(datas);
		return pageInfo;
	}

	// 查询所有
	@Override
	public List<Data> getAll() {
		return dataDao.getAll();
	}

	// 保存
	@Override
	public void save(Data data) throws RuntimeException {
		dataDao.insertSelective(data);
	}

	// 删除
	@Override
	public void delete(int id) throws RuntimeException {
		dataDao.deleteByPrimaryKey(id);
	}

	// 更新
	@Override
	public void update(Data data) throws RuntimeException {
		dataDao.updateByPrimaryKey(data);
	}
	//根据主键查询
	@Override
	public Data findById(Integer id) {
		return dataDao.selectByPrimaryKey(id);
	}

}
