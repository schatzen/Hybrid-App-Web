package com.tj.aop;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TestService;

@Controller
public class TestController {

	TestService test_service;

	public void setTest_service(TestService test_service) {
		this.test_service = test_service;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		
		Map map = test_service.list();
		
		//request binding
		model.addAttribute("map", map);
		
		return "test_list";//  /WEB-INF/views/test_list.jsp
	}
	
}
