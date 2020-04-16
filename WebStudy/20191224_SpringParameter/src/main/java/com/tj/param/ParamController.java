package com.tj.param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVo;

//�ݵ�� @Controller�ؾ� RequestMapping ���۵ȴ�

@Controller
public class ParamController {

	
	@RequestMapping("/delete.do")
	public String delete(int idx,Model model) {
		
		//Model���
		// forward : request binding
		// redirect: parameter���
		
		model.addAttribute("idx", idx);
		model.addAttribute("page", 1);
		
		
		//DispatcherServlet���� Client���� redirect�ϰԲ� ����
		return "redirect:list.do";
	}
	
	
	@RequestMapping("/list.do")
	public String list() {
		
		return "list";//forward view�� �ؼ�
	}
	
	
	// /qna.do?no=1
	//   produces="text/plain;charset=utf-8;"
	//   => response.setContentType("text/plain;charset=utf-8;");	����
	@RequestMapping(value="/qna.do",produces="text/plain;charset=utf-8;")
	@ResponseBody   //returun ���信 ����� ����ض�
	public String qna(int no) {
		
		String answer = "";
		if(no==1) answer="one";
		else if(no==2) answer="two";
		else if(no==3) answer="three";
		else if(no==4) answer="four";
		else if(no==5) answer="five";
		else answer="����?";
		
		String result 
		   = String.format("no=[%d]�� ����� [%s]�Դϴ�", no,answer);
		
		return result;
	}
	
	
	
	//�Է��� ����
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return "insert_form";
	}
	
	//���� �ޱ�
	// insert.do?name=ȫ�浿&age=20&tel=010-1111-1234&hobby=�&hobby=��ȭ
	@RequestMapping("/insert.do")
	public String insert(Model model,HttpServletRequest request){
		//  DispatcherServlet���� (model / request)��û
		
		String name     = request.getParameter("name");
		int    age      = Integer.parseInt(request.getParameter("age"));
		String tel      = request.getParameter("tel");
		String [] hobby = request.getParameterValues("hobby");
		
		PersonVo vo = new PersonVo(name, age, tel, hobby);
		//����->DB insert : ������������ Ȯ�θ� ...
		//model����: ��������� request binding�ȴ�
		model.addAttribute("title", "�����ޱ�");
		model.addAttribute("vo", vo);
		
		return "result_person";// forward�� jsp page
	}
	
	//������ �ޱ�
	// insert1.do?name=ȫ�浿&age=20&tel=010-1111-1234&hobby=�&hobby=��ȭ
	@RequestMapping("/insert1.do")
	public String insert1(
			// param name == ������ �����ϸ� ��������(@RequestParam)
			 @RequestParam("name") String name, 
			 int age,
			 String tel,
			 String [] hobby,
			 Model model){
		//  DispatcherServlet���� (model)��û
		
		PersonVo vo = new PersonVo(name, age, tel, hobby);
		//����->DB insert : ������������ Ȯ�θ� ...
		//model����: ��������� request binding�ȴ�
		model.addAttribute("title", "�����ιޱ�");
		model.addAttribute("vo", vo);
		
		return "result_person";// forward�� jsp page
	}
	
	//��ü�� �ޱ�
	// insert2.do?name=ȫ�浿&age=20&tel=010-1111-1234
	@RequestMapping("/insert2.do")
	public String insert2(PersonVo vo,Model model){
		//  DispatcherServlet���� (model)��û
		//  1.vo����
		//  2.parameter�޾Ƽ� vo�� �־��ش�
		
		//����->DB insert : ������������ Ȯ�θ� ...
		//model����: ��������� request binding�ȴ�
		model.addAttribute("title", "��ü�ιޱ�");
		model.addAttribute("vo", vo);
		
		return "result_person";// forward�� jsp page
	}
	
}
