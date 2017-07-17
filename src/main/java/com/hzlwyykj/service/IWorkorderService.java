package com.hzlwyykj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.User;
import com.hzlwyykj.model.WorkConditionVo;
import com.hzlwyykj.model.Workattach;
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

	// 通过workid查询处理人id
	public int findHandlePerByWid(String workid);

	// 保存
	void save(Workorder work);

	// 根据工单号查询附件
	List<Workattach> findAttacheByworkId(String workid);

	// 根据工单号更新
	void update(Workorder work);

	// 处理工单
	void updata(Workorder work, User user);
}
