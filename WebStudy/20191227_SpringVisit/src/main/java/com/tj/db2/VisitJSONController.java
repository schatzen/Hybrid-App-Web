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
public class VisitJSONController {

	VisitDao visit_dao;

	public VisitDao getVisit_dao() {
		return visit_dao;
	}

	public void setVisit_dao(VisitDao visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	
	
	@RequestMapping("/visit/json/list.do")
	//(Parameter��==���ź�����) ���������ϴ�
	//                             �ʼ��Է¿���
	//@RequestParam(value="search",required=true) String search,
	@ResponseBody
	public Map list(
			@RequestParam(value="search",required=false) String search,
			String search_text
			) {
		
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
			
		Map resultMap = new HashMap();
		resultMap.put("list", list);
			
		return resultMap;
	}
	
	
	//��� üũ
	@RequestMapping("/visit/json/check_pwd.do")
	@ResponseBody   //���� ��ȯ���� Ŭ���̾�Ʈ���� �ٷ� �����ض�..
	public Map check_pwd(int idx,String c_pwd) {
		
		//idx�� �ش�Ǵ� �Խù�������
		VisitVo vo = visit_dao.selectOne(idx);
		
		String result = "diff";
		//�Խù� ����� ���� �Է��� ����� ������ Ȯ��
		if (vo.getPwd().equals(c_pwd)) {
			result = "same";
		}
		
		Map map = new HashMap();
		map.put("result", result);
		
		return map;
		
		//Json���� �����Ͽ� ���� {"result":"same"}
		//String resultStr = String.format("{\"result\":\"%s\"}", result);
		//return resultStr;
	}
	
	
	
	@RequestMapping("/visit/json/insert.do")
	@ResponseBody
	public Map insert(VisitVo vo,HttpServletRequest request) {
		// visit/insert.do?name=ȫ�浿&content=����&pwd=123
		//����(��)�� ��ü�� �����ϸ� Spring���� �Ķ���͹ް�
		//��ü�� �����ؼ� �������ش�
		
		String ip = request.getRemoteAddr();
		// '\n' => '<br>'�� ����(����)
		String content = vo.getContent();
		content = content.replaceAll("\n", "<br>")
				         .replaceAll("\r", "");
		
		vo.setContent(content);
		vo.setIp(ip);
		//DB Insert
		int res = visit_dao.insert(vo);
		
		Map map = new HashMap();
		map.put("result", res);
		return map;
		
	}
	
	@RequestMapping("/visit/json/delete.do")
	@ResponseBody
	public Map delete(int idx) {
		
		int res = visit_dao.delete(idx);
		
		Map map = new HashMap();
		map.put("result", res);
		return map;
	}
	
		
	
	@RequestMapping("/visit/json/modify.do")
	@ResponseBody
	public Map modify(VisitVo vo,HttpServletRequest request) {
		
		String ip = request.getRemoteAddr();
		// '\n' => '<br>'�� ����(����)
		String content = vo.getContent();
		content = content.replaceAll("\n", "<br>")
				         .replaceAll("\r","");
		
		vo.setContent(content);
		vo.setIp(ip);
		
		int res = visit_dao.update(vo);
		
		Map map = new HashMap();
		map.put("result", res);
		return map;
		
	}
	
	
	
	
	
	
	
	
	
}
