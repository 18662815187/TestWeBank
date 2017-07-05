package com.hzlwyykj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzlwyykj.model.Handleworkhistory;

public interface HandleworkhistoryMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Handleworkhistory record);

	int insertSelective(Handleworkhistory record);

	Handleworkhistory selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Handleworkhistory record);

	int updateByPrimaryKey(Handleworkhistory record);

	// 根据workid查询
	List<Handleworkhistory> findById(String workid);

	/**
	 * 根据用户id和工单号查询本人操作过的退单记录排除重复
	 * 
	 * @param workid
	 *            map传值
	 * @param userid
	 *            map传值
	 * @return
	 * 
	 */
	List<Handleworkhistory> findByUidAndWid(@Param("workid") String workid, @Param("userid") Integer userid);
}