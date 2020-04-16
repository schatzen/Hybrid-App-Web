package com.tj.gallery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDao;
import vo.MemberVo;

@Controller
public class MemberController {

	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	MemberDao member_dao;

	public void setMember_dao(MemberDao member_dao) {
		this.member_dao = member_dao;
	}

	@RequestMapping("/member/list.do")
	public String list(Model model) {
		
		List<MemberVo> list = member_dao.selectList();
		
		model.addAttribute("list", list);
		
		return "member/member_list";
	}
	
	//로그인 폼..
	@RequestMapping("/member/login_form.do")
	public String login_form() {

		return "member/member_login_form";
	}
	
	@RequestMapping("/member/login.do")
	public String login(String id,String pwd,Model model) {
		
		//1.parameter받기
		//2.id에 해당되는 회원정보 구하기
		MemberVo  user = member_dao.selectOne(id);
		
		//id가 틀린경우
		if(user==null) { 
			//redirct시 parameter로 사용된다
			model.addAttribute("reason", "fail_id");
			//response.sendRedirect("login_form.do?reason=fail_id");
			return "redirect:login_form.do";
		}
		
		//비밀번호가 틀린경우
		if(user.getPwd().equals(pwd)==false) {
			
			model.addAttribute("reason", "fail_pwd");
			//response.sendRedirect("login_form.do?reason=fail_pwd");
			return "redirect:login_form.do";
		}
		
		//로그인 성공=>현재 로그인 상태를 세션에 저장(MemberVo)
		//HttpSession  session = request.getSession();
		//session binding
		session.setAttribute("user", user);
		
		//메인페이지로 이동
		//response.sendRedirect("../photo/list.do");
		return "redirect:../photo/list.do";
				
	}
	
	@RequestMapping("/member/logout.do")
	public String logout() {
		
		session.removeAttribute("user");
		
		return "redirect:../photo/list.do";
	}
	
	
	@RequestMapping("/member/insert_form.do")
	public String insert_form() {
		
		return "member/member_insert_form";
	}
	
	@RequestMapping("/member/insert_form2.do")
	public String insert_form2() {
		
		return "member/member_insert_form2";
	}
	
	@RequestMapping("/member/insert.do")
	public String insert(MemberVo vo) {
		
		//ip받기
		String ip		= request.getRemoteAddr();
		vo.setIp(ip);
		//DB insert
		int res = member_dao.insert(vo);
				
		return "redirect:list.do";
	}
	
	@RequestMapping("/member/delete.do")
	public String delete(int idx) {
		
		//DB delete
		int res = member_dao.delete(idx);
		
		return "redirect:list.do";
	}
	
	
	@RequestMapping("/member/modify_form.do")
	public String modify_form(int idx,Model model) {
		
		MemberVo vo = member_dao.selectOne(idx);
        
		model.addAttribute("vo", vo);
		
		return "member/modify_form";
	}
	
	@RequestMapping("/member/modify.do")
	public String modify(MemberVo vo) {
		
		//ip받기
		String ip		= request.getRemoteAddr();
		vo.setIp(ip);
		//DB update
		int res = member_dao.update(vo);
				
		return "redirect:list.do";
	}
	
	@RequestMapping(value="/member/check_id.do",
			        produces="text/plain;charset=utf-8;")
	@ResponseBody
	public String check_id(String id) {
		
		//id에 해당되는 회원정보 얻어온다
		MemberVo vo = member_dao.selectOne(id);
		
		boolean result = false;
		//id를 사용하는 회원정보가 없다
		if(vo==null) result=true;
		
		String jsonStr = String.format("{\"result\":%b}", result);
				
		return jsonStr;
	}
	
	
}






