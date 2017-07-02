package com.hzlwyykj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Dept;
import com.hzlwyykj.model.Role;
import com.hzlwyykj.model.User;
import com.hzlwyykj.service.IDeptService;
import com.hzlwyykj.service.IRoleService;
import com.hzlwyykj.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	@Resource
	private IRoleService roleService;
	@Resource
	private IDeptService deptService;

	// 跳转增加页面
	@RequestMapping("/init")
	public String tiIndex(Model model) {
		// 查询所有部门和角色用于添加页面表单的部门和权限选择
		List<Dept> depts = deptService.queryAll();
		List<Role> roles = roleService.queryAll();
		model.addAttribute("deptlist", depts);
		model.addAttribute("rolelist", roles);
		return "user/user";
	}

	@RequestMapping("/showAllUser")
	@ResponseBody
	public Object showAllUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> users = userService.getAllUser();
		String status = "1";
		map.put("msg", "查询成功");
		map.put("userList", users);
		map.put("status", status);
		return map;
	}

	// 列表页显示所有数据带分页和关键字检索
	@RequestMapping("/query")
	public String query(Model model, BaseVo vo) {
		PageInfo<User> pageInfo = userService.query(vo);
		model.addAttribute("pageModel", pageInfo);
		model.addAttribute("vo", vo);
		return "user/userlist";
	}

	// 保存、更新
	@RequestMapping("/save")
	public String save(User user) {
		if (user.getUserid() != null && user.getUserid() > 0) {
			userService.update(user);
		} else {
			userService.save(user);
		}
		return "redirect:/user/query";
	}

	// 跳转更新页面
	// @RequestMapping("/updatePage/{userid}")
	// public String updatePage(Model model, @PathVariable("id") int userid) {
	// List<Dept> depts = deptService.queryAll();
	// List<Role> roles = roleService.queryAll();
	// User user = userService.findById(userid);
	// model.addAttribute("deptlist", depts);
	// model.addAttribute("rolelist", roles);
	// model.addAttribute("user", user);
	// return "user/user";
	// }
	// 到修改页面
	@RequestMapping("/updatePage/{id}")
	public String updatePage(Model model, @PathVariable("id") int userid) {
		List<Dept> deptList = deptService.queryAll();
		List<Role> roleList = roleService.queryAll();
		model.addAttribute("deptlist", deptList);
		model.addAttribute("rolelist", roleList);
		// 根据主键id查询用户信息
		User user = userService.findById(userid);
		model.addAttribute("user", user);
		return "user/user";
	}

	// 删除
	@RequestMapping("delete")
	public String delete(int id) {
		userService.deleteById(id);
		return "redirect:/user/query";
	}

}
