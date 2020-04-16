package com.tj.db2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDao;
import vo.VisitVo;

@Controller
public class VisitController {

	VisitDao visit_dao;

	public VisitDao getVisit_dao() {
		return visit_dao;
	}

	public void setVisit_dao(VisitDao visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	
	
	@RequestMapping("/visit/list.do")
	//(Parameter��==���ź�����) ���������ϴ�
	//                             �ʼ��Է¿���
	//@RequestParam(value="search",required=true) String search,
	public String list(
			@RequestParam(value="search",required=false) String search,
			String search_text,
			Model model) {
		
		if(search==null) search="all";
		
		//�˻������� ���� ��ü
		Map map = new HashMap();
		
		//��ü�˻��� �ƴϸ�...
		if(search.equals("all")==false) {
			//�̸�+����
			if(search.equals("name_content")) {
				map.put("name", search_text);
				map.put("content", search_text);
			}else if(search.equals("name")) {
				//�̸�
				map.put("name", search_text);
			}else if(search.equals("content")) {
				//����
				map.put("content", search_text);
			}
		}
		
		//1.���� ��� ��������
		List<VisitVo> list = visit_dao.selectList(map);
		
		
		//DispatcherServlet���� ���޵ȴ�
		//��������� request binding
		model.addAttribute("list", list);
		
		return "visit/visit_list";
	}
	
	
	//��� üũ
	@RequestMapping("/visit/check_pwd.do")
	@ResponseBody   //���� ��ȯ���� Ŭ���̾�Ʈ���� �ٷ� �����ض�..
	public String check_pwd(int idx,String c_pwd) {
		
		//idx�� �ش�Ǵ� �Խù�������
		VisitVo vo = visit_dao.selectOne(idx);
		
		String result = "diff";
		//�Խù� ����� ���� �Է��� ����� ������ Ȯ��
		if (vo.getPwd().equals(c_pwd)) {
			result = "same";
		}
		
		//Json���� �����Ͽ� ���� {"result":"same"}
		String resultStr = String.format("{\"result\":\"%s\"}", result);
				
		return resultStr;
	}
	
	@RequestMapping("/visit/insert_form.do")
	public String insert_form() {
		
		return "visit/visit_insert_form";
	}
	
	@RequestMapping("/visit/insert.do")
	public String insert(VisitVo vo,HttpServletRequest request) {
		// visit/insert.do?name=ȫ�浿&content=����&pwd=123
		//����(��)�� ��ü�� �����ϸ� Spring���� �Ķ���͹ް�
		//��ü�� �����ؼ� �������ش�
		
		String ip = request.getRemoteAddr();
		// '\n' => '<br>'�� ����(����)
		String content = vo.getContent(); // \r\n
		content = content.replaceAll("\n", "<br>")
				         .replaceAll("\r", "");
		
		vo.setContent(content);
		vo.setIp(ip);
		//DB Insert
		int res = visit_dao.insert(vo);
		// redirect: <= DispatcherServlet���� 
		//              list.do�� redirect���Ѷ�
		return "redirect:list.do";
	}
	
	@RequestMapping("/visit/delete.do")
	public String delete(int idx) {
		
		int res = visit_dao.delete(idx);
		
		return "redirect:list.do";
	}
	
	
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(int idx,Model model) {
		
		VisitVo  vo = visit_dao.selectOne(idx);
		
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);
		
		model.addAttribute("vo", vo);
				
		return "visit/visit_modify_form";
	}
	
	@RequestMapping("/visit/modify.do")
	public String modify(VisitVo vo,HttpServletRequest request) {
		
		String ip = request.getRemoteAddr();
		// '\n' => '<br>'�� ����(����)
		String content = vo.getContent();
		content = content.replaceAll("\n", "<br>")
				         .replaceAll("\r", "");
		
		vo.setContent(content);
		vo.setIp(ip);
		
		int res = visit_dao.update(vo);
				
		return "redirect:list.do";
	}
	
	
	
	
	
	
	
	
	
}
