package com.hzlwyykj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.BaseVo;
import com.hzlwyykj.model.Menu;
import com.hzlwyykj.model.Role;
import com.hzlwyykj.service.IMenuService;
import com.hzlwyykj.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource
	private IRoleService roleService;
	@Resource
	private IMenuService menuService;

	// 列表页带分页和关键字检索
	@RequestMapping("query")
	public String query(Model model, BaseVo vo) {
		PageInfo<Role> list = roleService.query(vo);
		model.addAttribute("pageModel", list);
		model.addAttribute("vo", vo);
		return "role/rolelist";
	}

	// 进入新增页面
	@RequestMapping("/init")
	public String init(Model model) {
		List<Role> roles = roleService.queryAll();
		List<Menu> menus = menuService.getAll();
		model.addAttribute("rolelist", roles);
		model.addAttribute("menulist", menus);
		return "role/role";
	}

	// 新增、更新
	@RequestMapping("save")
	public String save(Role role) {
		if (role.getRid() != null && role.getRid() > 0) {
			roleService.update(role);
		} else {
			roleService.save(role);
		}
		return "redirect:/role/query";
	}

	// 到更新页面@PathVariable获取url中的id
	@RequestMapping("/updatePage/{id}")
	public String updatePage(Model model, @PathVariable("id") int id) {
		// 根据主键查询role角色
		Role role = roleService.findRoleById(id);
		// 查询所有权限菜单用于页面显示权限菜单结构
		List<Menu> menus = menuService.getAll();
		System.out.println(role.getMids() + "************************");
		model.addAttribute("role", role);
		model.addAttribute("menulist", menus);
		return "role/role";
	}

	// 删除
	@RequestMapping("/delete")
	public String delete(Integer id) {
		roleService.deleteById(id);
		return "redirect:/role/query";
	}

}
