package com.hzlwyykj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzlwyykj.dao.WorkorderMapper;
import com.hzlwyykj.model.WorkConditionVo;
import com.hzlwyykj.model.Workorder;
import com.hzlwyykj.service.IWorkorderService;

@Service
public class WorkorderServiceImpl implements IWorkorderService {
	@Resource
	private WorkorderMapper workDao;

	// 所有工单
	@Override
	public PageInfo<Workorder> query(WorkConditionVo vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		// 使用dao中query（vo）的方法
		List<Workorder> workorders = workDao.query(vo);
		PageInfo<Workorder> pageInfo = new PageInfo<>(workorders);
		return pageInfo;
	}

	// 根据主键查询指定工单信息
	@Override
	public Workorder findByWid(String workid) {
		return workDao.selectByPrimaryKey(workid);
	}

	// 根据工单号查询用户（customs）id
	@Override
	public int findIdByWid(String workid) {
		return workDao.findIdByWid(workid);
	}

	// 根据工单号查询问题类型编码
	@Override
	public int findProTypeByWid(String workid) {
		return workDao.findProTypeByWid(workid);
	}

	// 根据工单号查询处理人id
	@Override
	public int findHandlePerByWid(String workid) {
		return workDao.findHandlePerByWid(workid);
	}
}
