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
	
	// Client(외부) URL상  /hello.do
	@RequestMapping("/hello.do")
	public String hello() {
		
		return "hello";
	}
	
	
	@RequestMapping("/hi.do")
	public String hi() {
		
		return "hi/hi";
	}
	
	
	//누가 호출했냐?
	@RequestMapping("/test.do")
	public String test(Model model) {
		
		String msg = "test:안녕";
		//DispatcherServlet내에 만들어놓은 저장소에 
		//데이터를 넣는다(결과적으로 request binding)
		model.addAttribute("msg",msg);
		
		//누구한테 반환하냐?
		return "test_hello";//forward시킬 jsp
	}

	
	@RequestMapping("/test2.do")
	public ModelAndView  test2() {
		
		String msg = "test2:Hi~~";
		
		//Data + View 한꺼번에 넘긴다
		ModelAndView mv = new ModelAndView();
		
		//Data
		mv.addObject("msg", msg);
		//View
		mv.setViewName("test_hello");
		
		return mv;//누구에게 반환(호출한 객체에게 반환)
	}
	
	
	
}
