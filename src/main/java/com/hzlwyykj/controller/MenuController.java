package com.hzlwyykj.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping("/query")
	public String query(Model model, BaseVo vo) {
		PageInfo<Menu> pageInfo = menuService.query(vo);
		model.addAttribute("pageModel", pageInfo);
		model.addAttribute("vo", vo);
		return "menu/menulist";
	}
}
