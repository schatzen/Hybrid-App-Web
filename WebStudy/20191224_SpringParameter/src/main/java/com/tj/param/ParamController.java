package com.tj.param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVo;

//반드시 @Controller해야 RequestMapping 동작된다

@Controller
public class ParamController {

	
	@RequestMapping("/delete.do")
	public String delete(int idx,Model model) {
		
		//Model기능
		// forward : request binding
		// redirect: parameter사용
		
		model.addAttribute("idx", idx);
		model.addAttribute("page", 1);
		
		
		//DispatcherServlet에게 Client에게 redirect하게끔 설정
		return "redirect:list.do";
	}
	
	
	@RequestMapping("/list.do")
	public String list() {
		
		return "list";//forward view로 해석
	}
	
	
	// /qna.do?no=1
	//   produces="text/plain;charset=utf-8;"
	//   => response.setContentType("text/plain;charset=utf-8;");	동일
	@RequestMapping(value="/qna.do",produces="text/plain;charset=utf-8;")
	@ResponseBody   //returun 응답에 결과로 사용해라
	public String qna(int no) {
		
		String answer = "";
		if(no==1) answer="one";
		else if(no==2) answer="two";
		else if(no==3) answer="three";
		else if(no==4) answer="four";
		else if(no==5) answer="five";
		else answer="뭐지?";
		
		String result 
		   = String.format("no=[%d]는 영어로 [%s]입니다", no,answer);
		
		return result;
	}
	
	
	
	//입력폼 띄우기
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return "insert_form";
	}
	
	//직접 받기
	// insert.do?name=홍길동&age=20&tel=010-1111-1234&hobby=운동&hobby=영화
	@RequestMapping("/insert.do")
	public String insert(Model model,HttpServletRequest request){
		//  DispatcherServlet에게 (model / request)요청
		
		String name     = request.getParameter("name");
		int    age      = Integer.parseInt(request.getParameter("age"));
		String tel      = request.getParameter("tel");
		String [] hobby = request.getParameterValues("hobby");
		
		PersonVo vo = new PersonVo(name, age, tel, hobby);
		//원래->DB insert : 뷰페이지에서 확인만 ...
		//model저장: 결과적으로 request binding된다
		model.addAttribute("title", "직접받기");
		model.addAttribute("vo", vo);
		
		return "result_person";// forward될 jsp page
	}
	
	//낱개로 받기
	// insert1.do?name=홍길동&age=20&tel=010-1111-1234&hobby=운동&hobby=영화
	@RequestMapping("/insert1.do")
	public String insert1(
			// param name == 변수명 동일하면 생략가능(@RequestParam)
			 @RequestParam("name") String name, 
			 int age,
			 String tel,
			 String [] hobby,
			 Model model){
		//  DispatcherServlet에게 (model)요청
		
		PersonVo vo = new PersonVo(name, age, tel, hobby);
		//원래->DB insert : 뷰페이지에서 확인만 ...
		//model저장: 결과적으로 request binding된다
		model.addAttribute("title", "낱개로받기");
		model.addAttribute("vo", vo);
		
		return "result_person";// forward될 jsp page
	}
	
	//객체로 받기
	// insert2.do?name=홍길동&age=20&tel=010-1111-1234
	@RequestMapping("/insert2.do")
	public String insert2(PersonVo vo,Model model){
		//  DispatcherServlet에게 (model)요청
		//  1.vo생성
		//  2.parameter받아서 vo에 넣어준다
		
		//원래->DB insert : 뷰페이지에서 확인만 ...
		//model저장: 결과적으로 request binding된다
		model.addAttribute("title", "객체로받기");
		model.addAttribute("vo", vo);
		
		return "result_person";// forward될 jsp page
	}
	
}
