package com.hzlwyykj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzlwyykj.model.User;
import com.hzlwyykj.service.IUserService;

@Controller
@RequestMapping("/")
public class LoginController {
	@Resource
	private IUserService userService;

	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("-----------------------" + username + "------------------" + password);
		User user = userService.findByUserName(username, password);
		if (user != null) {
			model.addAttribute("user", user);
			session.setAttribute("user", user);
			return "forward:home.jsp";
		} else {
			model.addAttribute("msg", "用户名或者密码错误");
			return "forward:index.jsp";
		}
	}

	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		// session.removeAttribute("user");
		session.invalidate();
		return "redirect:/index.jsp";

	}
}
