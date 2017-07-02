package com.hzlwyykj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzlwyykj.dao.RoleMapper;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Role;
import com.hzlwyykj.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	@Resource
	private RoleMapper roleDao;

	// 列表页带分页和关键字查询
	@Override
	public PageInfo<Role> query(BaseVo vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Role> roles = roleDao.query(vo);
		PageInfo<Role> pageInfo = new PageInfo<>(roles);
		return pageInfo;
	}

	// 查询所有
	@Override
	public List<Role> queryAll() {
		return roleDao.queryAll();
	}

	// 新增保存
	@Override
	public void save(Role role) throws RuntimeException {
		// 先保存主表
		roleDao.insertSelective(role);
		// 获取所有权限
		List<Integer> mids = role.getMids();
		System.out.println(mids);
		// 获取保存role后生成的id
		int rid = roleDao.selectLastId();
		// 保存到附表
		if (mids != null && mids.size() > 0) {
			for (Integer mid : mids) {
				roleDao.insertRidAndMid(rid, mid);
			}
		}
	}

	// 更新
	@Override
	public void update(Role role) throws RuntimeException {
		// 先更新主表
		roleDao.updateByPrimaryKey(role);
		// 根据RID删除之前的附表权限记录
		roleDao.deleteRidAndMidByRid(role.getRid());
		// 获取现在role对象的mids
		List<Integer> mids = role.getMids();
		System.out.println(mids);
		// 保存到附表
		if (mids != null && mids.size() > 0) {
			for (Integer mid : mids) {
				roleDao.insertRidAndMid(role.getRid(), mid);
			}
		}
	}

	@Override
	public Role findRoleById(Integer id) {
		Role role = roleDao.selectByPrimaryKey(id);
		//此处一定要小心必须查出所有mid并set进role
		List<Integer> mids = roleDao.findMidAndRidByRid(id);
		if(mids!=null&&mids.size()>0){
			role.setMids(mids);
		}
		return role;
	}

	@Override
	public void deleteById(Integer id) throws RuntimeException {
		//先删附表
		roleDao.deleteRidAndMidByRid(id);
		//再删主表
		roleDao.deleteByPrimaryKey(id);
	}

}
