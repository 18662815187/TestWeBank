package com.hzlwyykj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Data;
import com.hzlwyykj.service.IDataService;

@Controller
@RequestMapping("/data")
public class DataController {
	@Resource
	private IDataService dataService;

	// 列表页带分页
	@RequestMapping("/query")
	public String query(Model model, BaseVo vo) {
		PageInfo<Data> pageInfo = dataService.query(vo);
		model.addAttribute("pageModel", pageInfo);
		return "data/datalist";
	}

	// 跳转到增加页
	@RequestMapping("/init")
	public String init(Model model) {
		List<Data> datas = dataService.getAll();
		model.addAttribute("datalist", datas);
		return "data/data";
	}

	// 保存、更新
	@RequestMapping("/save")
	public String save(Data data) {
		if (data.getId() != null && data.getId() > 0) {
			dataService.update(data);
		} else {
			dataService.save(data);
		}
		return "redirect:/data/query";
	}

	// 到编辑页面
	@RequestMapping("/updatePage/{id}")
	public String updatePage(Model model, @PathVariable("id") int id) {
		List<Data> datas = dataService.getAll();
		model.addAttribute("datalist", datas);
		Data data = dataService.findById(id);
		model.addAttribute("data", data);
		return "data/data";
	}

	// 删除
	@RequestMapping("/delete")
	public String delete(int id) {
		dataService.delete(id);
		return "redirect:/data/query";
	}
}
