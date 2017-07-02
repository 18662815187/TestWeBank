package com.hzlwyykj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Role;

public interface RoleMapper {
	int deleteByPrimaryKey(Integer rid);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(Integer rid);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	List<Role> query(BaseVo vo);
	
	List<Role> queryAll();
	
	/**
	 * 保存到附表t_role_menu，不使用@param注解时只能传一个参数之后xml文件parameterType="map"
	 * @param rid
	 * @param mid
	 */
	void insertRidAndMid(@Param("rid")Integer rid,@Param("mid") Integer mid);
	/**
	 * 根据角色id查询所拥有的菜单权限,mid是int类型且是List类型
	 * @param id
	 * @return
	 */
	List<Integer> findMidAndRidByRid(int id);
	/**
	 * 根据角色id删除中间表
	 * @param rid
	 */
	void deleteRidAndMidByRid(Integer rid);
	
	/**
	 *获取最新的id
	 */
	int selectLastId();
	
}