package com.hzlwyykj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Dept;
import com.hzlwyykj.service.IDeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Resource
	private IDeptService deptService;

	// 查询所有数据带分页和关键字查询
	@RequestMapping("/query")
	public String query(Model model, BaseVo vo) {
		PageInfo<Dept> list = deptService.query(vo);
		model.addAttribute("pageModel", list);
		model.addAttribute("vo", vo);
		return "dept/deptlist";

	}

	// 进入新增页面
	@RequestMapping("/init")
	public String init(Model model) {
		List<Dept> depts = deptService.queryAll();
		model.addAttribute("deptlest", depts);
		return "dept/dept";
	}

	// 保存或更新
	@RequestMapping("save")
	public String save(Dept dept) {
		if (dept.getId() != null && dept.getId() > 0) {
			deptService.update(dept);
		} else {
			deptService.save(dept);
		}
		return "redirect:/dept/query";
	}
	//到更新页面通过｛id｝传入id,@PathVariable作用是获取URL中传入的变量与@RequestParam的区别在于@RequestParam只能用来获得静态的URL请求入参，也就是请求参数url后面跟?id=1。
	@RequestMapping("/updatePage/{id}")
	public String upadtePage(Model model,@PathVariable("id")int id){
		Dept dept = deptService.findById(id);
		model.addAttribute("dept", dept);
		return "dept/dept";
	}
	
//	@RequestMapping("/updatePage")
//	public String upadtePage(Model model,int id){
//		Dept dept = deptService.findById(id);
//		model.addAttribute("dept", dept);
//		return "dept/dept";
//	}
	//通过id删除部门
	@RequestMapping("/delete")
	public String delete(int id){
		deptService.delete(id);
		return "redirect:/dept/query";
	}
}
