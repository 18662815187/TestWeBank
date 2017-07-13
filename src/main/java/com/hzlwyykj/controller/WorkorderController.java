package com.hzlwyykj.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.hzlwyykj.model.Customer;
import com.hzlwyykj.model.Data;
import com.hzlwyykj.model.Dept;
import com.hzlwyykj.model.Handleworkhistory;
import com.hzlwyykj.model.User;
import com.hzlwyykj.model.WorkConditionVo;
import com.hzlwyykj.model.Workattach;
import com.hzlwyykj.model.Workorder;
import com.hzlwyykj.service.ICustomsService;
import com.hzlwyykj.service.IDataService;
import com.hzlwyykj.service.IDeptService;
import com.hzlwyykj.service.IHandleworkhistoryService;
import com.hzlwyykj.service.IUserService;
import com.hzlwyykj.service.IWorkorderService;
import com.hzlwyykj.tools.GetId;

@Controller
@RequestMapping("/work")
public class WorkorderController {
	@Resource
	private IUserService userService;
	@Resource
	private IWorkorderService workorderService;
	@Resource
	private IDeptService deptService;
	@Resource
	private IDataService dataService;
	@Resource
	private IHandleworkhistoryService handService;
	@Resource
	private ICustomsService customerService;

	// 查询工单列表页
	@RequestMapping("queryAll")
	public String queryAll(Model model, WorkConditionVo vo) {
		PageInfo<Workorder> pageInfo = workorderService.query(vo);
		List<Dept> depts = deptService.queryAll();
		// System.out.println(depts);
		// System.out.println(pageInfo);
		model.addAttribute("deptlist", depts);
		model.addAttribute("pageModel", pageInfo);
		model.addAttribute("vo", vo);
		return "work/worklist";
	}

	// 通过工单号超链接跳转到详细页
	@RequestMapping("/handworkPage/{workid}")
	public String handworkPage(Model model, @PathVariable("workid") String workid, HttpSession session) {
		// 根据工单号查询工单
		Workorder workorder = workorderService.findByWid(workid);
		model.addAttribute("work", workorder);
		// 获取所有部门
		List<Dept> depts = deptService.queryAll();
		model.addAttribute("deptlist", depts);
		// 获取数据字典
		List<Data> datas = dataService.getAll();
		model.addAttribute("datalist", datas);
		// 根据订单号查询工单历史
		List<Handleworkhistory> handleworkhistories = handService.findById(workid);
		model.addAttribute("historylist", handleworkhistories);
		// 通过工单查询customsid
		int id = workorderService.findIdByWid(workid);
		// 根据id查询customs所有信息
		Customer customer = customerService.findById(id);
		System.err.println(customer.getCustomertype());
		model.addAttribute("customer", customer);
		// 根据工单号查问题编号
		int pid = workorderService.findProTypeByWid(workid);
		Data data = dataService.findById(pid);
		model.addAttribute("data", data);
		// 根据工单号查找处理人
		int handleId = workorderService.findHandlePerByWid(workid);
		User handlePer = userService.findById(handleId);
		model.addAttribute("handlePer", handlePer);
		// 获取当前用户处理过的该工单号的历史记录
		User user = (User) session.getAttribute("user");
		System.out.println(user.getUserid());
		List<Handleworkhistory> list = handService.findByIdAndUid(workid, user.getUserid());
		model.addAttribute("backUserList", list);
		return "work/handwork";
	}

	// 根据部门编号查询人员
	@RequestMapping("/queryByDid")
	@ResponseBody
	public List<User> queryByDid(int did) {
		List<User> list = userService.findByDid(did);
		return list;
	}

	// 跳转到创建工单页面
	@RequestMapping("/init")
	public String init(Model model) {
		List<Dept> depts = deptService.queryAll();
		List<Data> datas = dataService.getAll();
		model.addAttribute("deptlist", depts);
		model.addAttribute("datalist", datas);
		return "work/work";
	}

	// 保存
	@RequestMapping("/save")
	public String save(@RequestParam("files")MultipartFile[] files, Workorder work) throws IllegalStateException, IOException {
		List<Workattach> attaches = new ArrayList<>();
		// 保存文件
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				Workattach attach = new Workattach();
				// 旧名字
				String oldname = file.getOriginalFilename();
				// 获取后缀
				int opt = oldname.lastIndexOf(".");
				String ext = oldname.substring(opt);// 获取后缀，如.jpg
				// 新名字，唯一的
				String newfilename = GetId.getNewFileName() + ext;
				System.out.println(newfilename + "*****************");
				File newfilepath = new File("D:\\测试项目上传路径\\" + newfilename);
				if (!newfilepath.exists()) {
					newfilepath.mkdirs();
				}
				file.transferTo(newfilepath);
				System.out.println(newfilepath + "**************");
				attach.setNewfilename(newfilename);
				attach.setOldfilename(oldname);
				System.out.println(attach.getOldfilename() + "************" + attach.getNewfilename());
				attaches.add(attach);
			}
		}
		work.setAttaches(attaches);
		workorderService.save(work);
		return "redirect:/work/queryAll";
	}
}
