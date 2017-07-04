package com.hzlwyykj.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.WorkConditionVo;
import com.hzlwyykj.model.Workorder;
import com.hzlwyykj.service.IWorkorderService;

@Controller
@RequestMapping("/work")
public class WorkorderController {
	@Resource
	private IWorkorderService workorderService;

	// 查询工单列表页
	@RequestMapping("queryAll")
	public String queryAll(Model model, WorkConditionVo vo) {
		PageInfo<Workorder> pageInfo = workorderService.query(vo);
		model.addAttribute("pageModel", pageInfo);
		model.addAttribute("vo", vo);
		return "work/worklist";
	}
}
