package com.hzlwyykj.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzlwyykj.dao.CustomerMapper;
import com.hzlwyykj.dao.DeptMapper;
import com.hzlwyykj.dao.HandleworkhistoryMapper;
import com.hzlwyykj.dao.WorkattachMapper;
import com.hzlwyykj.dao.WorkorderMapper;
import com.hzlwyykj.model.Dept;
import com.hzlwyykj.model.Handleworkhistory;
import com.hzlwyykj.model.User;
import com.hzlwyykj.model.WorkConditionVo;
import com.hzlwyykj.model.Workattach;
import com.hzlwyykj.model.Workorder;
import com.hzlwyykj.service.IWorkorderService;
import com.hzlwyykj.tools.GetId;

@Service
public class WorkorderServiceImpl implements IWorkorderService {
	@Resource
	private WorkorderMapper workDao;
	@Resource
	private CustomerMapper customerDao;
	@Resource
	private WorkattachMapper attachDao;
	@Resource
	private DeptMapper deptDao;
	@Resource
	private HandleworkhistoryMapper hhDao;

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

	// 保存
	@Override
	public void save(Workorder work) {
		// 保存到客户表
		customerDao.insertSelective(work.getCustomer());
		// 保存工单到工单表
		String workid = GetId.getWorkid();
		work.setWorkorderid(workid);
		System.out.println("***************" + work.getCustomer().getId());
		work.setCustomerid(work.getCustomer().getId());
		work.setCustomername(work.getCustomer().getCustomername());
		work.setCentificatenumber(work.getCustomer().getCentificatenumber());
		workDao.insertSelective(work);
		// 保存到附件表
		List<Workattach> attaches = work.getAttaches();
		if (attaches != null && attaches.size() > 0) {
			for (Workattach attach : attaches) {
				attach.setWorkid(workid);
				attachDao.insertSelective(attach);
			}
		}
	}

	// 通过工单号查询附件
	@Override
	public List<Workattach> findAttacheByworkId(String workid) {
		return attachDao.findAttacheByWorkid(workid);
	}

	// 根据工单号更新
	@Override
	public void update(Workorder work) {
		workDao.updateByPrimaryKey(work);
		String workid = work.getWorkorderid();
		System.out.println("********************" + workid);
		// 更新客户表
		customerDao.updateByPrimaryKey(work.getCustomer());
		// 更新附件表
		List<Workattach> attaches = work.getAttaches();
		if (attaches != null && attaches.size() > 0) {
			for (Workattach attach : attaches) {
				attach.setWorkid(workid);
				attachDao.insertSelective(attach);
			}
		}
		// System.out.println(JSON.toJSON(attaches));
		// work.setWorkorderid(workid);
		// System.out.println("***************" + work.getCustomer().getId());
		// work.setCustomerid(work.getCustomer().getId());
		// work.setCustomername(work.getCustomer().getCustomername());
		// work.setCentificatenumber(work.getCustomer().getCentificatenumber());

	}

	// 处理工单
	@Override
	public void updata(Workorder work, User user) {
		Handleworkhistory hh = new Handleworkhistory();
		int status = work.getStatus();
		switch (status) {
		case 1:
			workDao.updateByPrimaryKeySelective(work);
			hh.setActionstr("转办");
			break;

		case 2:
			workDao.updateByPrimaryKeySelective(work);
			hh.setActionstr("归档");
			break;

		case 3:
			workDao.updateByPrimaryKeySelective(work);
			hh.setActionstr("退单");
			break;

		case 4:
			workDao.updateByPrimaryKeySelective(work);
			hh.setActionstr("挂起");
			break;

		default:
			workDao.updateByPrimaryKeySelective(work);
			hh.setActionstr("未处理");
			break;
		}
		// 保存到历史记录表
		hh.setWorkorderid(work.getWorkorderid());
		// 设置处理意见
		hh.setDescs(work.getDescs());
		// 设置处理组
		hh.setHandlegroup(user.getDid());
		Dept dept = deptDao.selectByPrimaryKey(user.getDid());
		// 设置处理人
		hh.setHandlegroupname(dept.getName());
		hh.setHandlepersonname(user.getUsername());
		// 保存历史记录
		hhDao.insertSelective(hh);
	}

}
