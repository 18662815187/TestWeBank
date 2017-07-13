package com.hzlwyykj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer userid);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userid);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> getAllUser();

	User findByUserName(String username, String password);

	List<User> query(BaseVo vo);

	// 将用户和角色信息保存到附表
	/*
	 * @param userid
	 * 
	 * @param rid
	 */
	int insertUidAndRid(@Param("userid") Integer userid, @Param("rid") Integer rid);

	// 通过uid删除附表信息
	void deleteRidAndUidByUid(Integer userid) throws RuntimeException;
	/**
	 *获取最新的id
	 */
	int selectLastId();
	//通过部门编号查询人员
	List<User> findByDid(int did);
}