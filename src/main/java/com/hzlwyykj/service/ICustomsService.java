package com.hzlwyykj.service;

import com.hzlwyykj.model.Customer;

public interface ICustomsService {
	//根据id查询所有
	Customer findById(int id);
}
