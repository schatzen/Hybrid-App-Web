package com.tj.testmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	public TestController() {
		// TODO Auto-generated constructor stub
		System.out.println("--TestController()--");
	}
	
	// Client(�ܺ�) URL��  /hello.do
	@RequestMapping("/hello.do")
	public String hello() {
		
		return "hello";
	}
	
	
	@RequestMapping("/hi.do")
	public String hi() {
		
		return "hi/hi";
	}
	
	
	//���� ȣ���߳�?
	@RequestMapping("/test.do")
	public String test(Model model) {
		
		String msg = "test:�ȳ�";
		//DispatcherServlet���� �������� ����ҿ� 
		//�����͸� �ִ´�(��������� request binding)
		model.addAttribute("msg",msg);
		
		//�������� ��ȯ�ϳ�?
		return "test_hello";//forward��ų jsp
	}

	
	@RequestMapping("/test2.do")
	public ModelAndView  test2() {
		
		String msg = "test2:Hi~~";
		
		//Data + View �Ѳ����� �ѱ��
		ModelAndView mv = new ModelAndView();
		
		//Data
		mv.addObject("msg", msg);
		//View
		mv.setViewName("test_hello");
		
		return mv;//�������� ��ȯ(ȣ���� ��ü���� ��ȯ)
	}
	
	
	
}
