package com.hzlwyykj.service;

import java.util.List;


import com.hzlwyykj.model.Handleworkhistory;

public interface IHandleworkhistoryService {
	// 根据工单号查询历史
	List<Handleworkhistory> findById(String workid);

	// 根据用户id和工单号查询本人操作过的退单记录排除重复
	List<Handleworkhistory> findByIdAndUid(String workid,int userid);
}
