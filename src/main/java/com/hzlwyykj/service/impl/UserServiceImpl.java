package com.hzlwyykj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzlwyykj.dao.UserMapper;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.User;
import com.hzlwyykj.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userDao;

	// 获取所有用户
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	// 登录验证
	@Override
	public User findByUserName(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username, password);
	}

	// 列表页带分页和关键字查询
	@Override
	public PageInfo<User> query(BaseVo vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<User> users = userDao.query(vo);
		PageInfo<User> pageInfo = new PageInfo<>(users);
		return pageInfo;
	}

	// 新增
	@Override
	public void save(User user) throws RuntimeException {
		// 先保存user主表基本信息
		userDao.insertSelective(user);
		// 查询最后生成的uid
		int userid = userDao.selectLastId();
		// 获取提交过来的user对象内的权限id（list类型）
		List<Integer> rids = user.getRids();
		// 保存user和role信息的附表
		if (rids != null && rids.size() > 0) {
			for (Integer rid : rids) {
				userDao.insertUidAndRid(userid, rid);
			}
		}
	}

	// 更新
	@Override
	public void update(User user) throws RuntimeException {
		// 先更新主表信息
		userDao.updateByPrimaryKey(user);

		// 根据uid删除附表信息
		userDao.deleteRidAndUidByUid(user.getUserid());
		// 获取提交过来的user对象内的权限id（list类型）
		List<Integer> rids = user.getRids();
		// 保存user和role信息的附表
		if (rids != null && rids.size() > 0) {
			for (Integer rid : rids) {
				userDao.insertUidAndRid(user.getUserid(), rid);
			}
		}
	}

	// 通过主键查询用户
	@Override
	public User findById(int id) {
		return userDao.selectByPrimaryKey(id);
	}

	// 删除
	@Override
	public void deleteById(int id) throws RuntimeException {
		// 先删附表
		userDao.deleteRidAndUidByUid(id);
		// 删主表
		userDao.deleteByPrimaryKey(id);
	}

	// 根据部门id查询人员
	@Override
	public List<User> findByDid(int did) {
		return userDao.findByDid(did);
	}

}
