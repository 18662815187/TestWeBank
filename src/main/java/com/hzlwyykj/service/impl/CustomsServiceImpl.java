package com.hzlwyykj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hzlwyykj.dao.CustomerMapper;
import com.hzlwyykj.model.Customer;
import com.hzlwyykj.service.ICustomsService;

@Service
public class CustomsServiceImpl implements ICustomsService {
	@Resource
	private CustomerMapper customerDao;

	// 根据id查询所有
	@Override
	public Customer findById(int id) {
		return customerDao.selectByPrimaryKey(id);
	}

}
