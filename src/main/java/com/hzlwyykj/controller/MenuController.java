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
import com.hzlwyykj.service.IMenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Resource
	private IMenuService menuService;

	// 列表页到分页和关键字查询
	@RequestMapping("/query")
	public String query(Model model, BaseVo vo) {
		PageInfo<Menu> pageInfo = menuService.query(vo);
		model.addAttribute("pageModel", pageInfo);
		model.addAttribute("vo", vo);
		return "menu/menulist";
	}

	// 到新增页面
	@RequestMapping("init")
	public String init(Model model) {
		List<Menu> menus = menuService.getAll();
		model.addAttribute("menulist", menus);
		return "menu/menu";
	}

	// 保存、更新
	@RequestMapping("save")
	public String save(Menu menu) {
		if (menu.getMid() != null && menu.getMid() > 0) {
			menuService.update(menu);
		} else {
			menuService.save(menu);
		}
		return "redirect:/menu/query";
	}

	// 到编辑页面
	@RequestMapping("/updatePage/{id}")
	public String updatePage(Model model, @PathVariable("id") int id) {
		// 查所有菜单用于编辑页面显示所有下拉选项
		List<Menu> menus = menuService.getAll();
		model.addAttribute("menulist", menus);
		Menu menu = menuService.findById(id);
		model.addAttribute("menu", menu);
		return "menu/menu";
	}

	// 删除
	@RequestMapping("/delete")
	public String deleteById(int id) {
		menuService.deleteById(id);
		return "redirect:/menu/query";
	}

}
