package com.hzlwyykj.dao;

import java.util.List;

import com.hzlwyykj.model.WorkConditionVo;
import com.hzlwyykj.model.Workorder;

public interface WorkorderMapper {
	int deleteByPrimaryKey(String workorderid);

	int insert(Workorder record);

	int insertSelective(Workorder record);

	Workorder selectByPrimaryKey(String workorderid);

	int updateByPrimaryKeySelective(Workorder record);

	int updateByPrimaryKey(Workorder record);

	/**
	 * 查询工单
	 * 
	 * @param vo
	 * @return
	 */
	List<Workorder> query(WorkConditionVo vo);

	// 查询所有
	List<Workorder> getAll();

	// 通过工单查找customsID
	int findIdByWid(String workid);

	// 通过工单号查找问题类型编号
	int findProTypeByWid(String workid);

	// 通过工单号查找处理人id
	int findHandlePerByWid(String workid);

}