package com.tj.rmiclient;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDao;
import vo.DeptVo;

@Controller
public class DeptController {

	DeptDao dept_dao;

	public void setDept_dao(DeptDao dept_dao) {
		this.dept_dao = dept_dao;
	}
	
		
	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		//                           RMI
		List<DeptVo> list = dept_dao.selectList();
		
		model.addAttribute("list", list);
		
		return "dept/dept_list";
	}
	
	
	
}
