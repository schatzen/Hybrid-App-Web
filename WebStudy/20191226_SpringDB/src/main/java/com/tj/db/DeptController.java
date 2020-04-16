package com.tj.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.DeptService;
import vo.DeptVo;

@Controller
public class DeptController {

	DeptService dept_service;

	public DeptService getDept_service() {
		return dept_service;
	}

	public void setDept_service(DeptService dept_service) {
		this.dept_service = dept_service;
	}
	
	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		
		List<DeptVo> list = dept_service.selectList();
		
		//DispatcherServlet���� �������� �ӽ�����ҿ� �ִ´�
		//�ӽ�������� ����� Model�� ��ȭ �Ǿ��ִ�.
		//��������� DispatcherServlet�� request binding��Ų��
		model.addAttribute("list", list);
		
		
		//         prefix +            view_name       +  suffix 
		//prefix= "/WEB-INF/views/" + "dept/dept_list" + .jsp(suffix)
		return "dept/dept_list";
	}
	
	
	
	
}
