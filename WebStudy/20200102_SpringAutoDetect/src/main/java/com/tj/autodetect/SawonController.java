package com.tj.autodetect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.SawonService;
import vo.SawonVo;

@Controller
public class SawonController {

	@Autowired
	SawonService  sawon_service;
	
	public SawonController() {
		// TODO Auto-generated constructor stub
		System.out.println("--SawonController()--");
	}
	
	
	
	@RequestMapping("/sawon/list.do")
	public String list(Model model) {
		
		//목록가져오기
		List<SawonVo> list = sawon_service.selectList();
		
		//model통한 request binding
		model.addAttribute("list", list);
		
		
		return "sawon/sawon_list";//view forward
	}
	
	
}
