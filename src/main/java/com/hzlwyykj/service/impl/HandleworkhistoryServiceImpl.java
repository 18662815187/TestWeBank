package com.hzlwyykj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hzlwyykj.dao.HandleworkhistoryMapper;
import com.hzlwyykj.model.Handleworkhistory;
import com.hzlwyykj.service.IHandleworkhistoryService;

@Service
public class HandleworkhistoryServiceImpl implements IHandleworkhistoryService {
	@Resource
	private HandleworkhistoryMapper handDao;

	// 根据workid查询
	@Override
	public List<Handleworkhistory> findById(String workid) {
		return handDao.findById(workid);
	}

	// 根据用户id和工单号查询本人操作过的退单记录排除重复
	@Override
	public List<Handleworkhistory> findByIdAndUid(String workid, int userid) {
		
		return handDao.findByUidAndWid(workid, userid);
	}

}
