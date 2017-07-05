package com.hzlwyykj.service;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.WorkConditionVo;
import com.hzlwyykj.model.Workorder;

public interface IWorkorderService {
	// 列表页带分页、关键字
	PageInfo<Workorder> query(WorkConditionVo vo);

	// 根据workorderid查询
	Workorder findByWid(String workid);

	// 通过workid查找customsID
	public int findIdByWid(String workid);

	// 通过workid查询problemtype
	public int findProTypeByWid(String workid);
	//通过workid查询处理人id
	public int findHandlePerByWid(String workid);
}
