package com.tj.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test/test.do")
	@ResponseBody
	public String test() {
		return "test";
	}
	
	@RequestMapping(value="/admin/list.do",produces="text/html;charset=utf-8;")
	@ResponseBody
	public String admin_list() {
		return "관리자 페이지";
	}
	
	@RequestMapping(value="/adult/list.do",produces="text/html;charset=utf-8;")
	@ResponseBody
	public String adult_list() {
		return "성인 페이지";
	}
	
	@RequestMapping(value="/member/login_form.do",produces="text/html;charset=utf-8;")
	@ResponseBody
	public String login_form() {
		return "로그인 폼 페이지";
	}
	
}
