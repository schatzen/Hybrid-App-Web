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
	//(Parameter명==수신변수명) 생략가능하다
	//                             필수입력여부
	//@RequestParam(value="search",required=true) String search,
	@ResponseBody
	public Map list(
			@RequestParam(value="search",required=false) String search,
			String search_text
			) {
		
		if(search==null) search="all";
		
		//검색정보를 담을 객체
		Map map = new HashMap();
		
		//전체검색이 아니면...
		if(search.equals("all")==false) {
			//이름+내용
			if(search.equals("name_content")) {
				map.put("name", search_text);
				map.put("content", search_text);
			}else if(search.equals("name")) {
				//이름
				map.put("name", search_text);
			}else if(search.equals("content")) {
				//내용
				map.put("content", search_text);
			}
		}
		
		//1.방명록 목록 가져오기
		List<VisitVo> list = visit_dao.selectList(map);
			
		Map resultMap = new HashMap();
		resultMap.put("list", list);
			
		return resultMap;
	}
	
	
	//비번 체크
	@RequestMapping("/visit/json/check_pwd.do")
	@ResponseBody   //현재 반환값을 클라이언트에게 바로 전송해라..
	public Map check_pwd(int idx,String c_pwd) {
		
		//idx에 해당되는 게시물얻어오기
		VisitVo vo = visit_dao.selectOne(idx);
		
		String result = "diff";
		//게시물 비번과 내가 입력한 비번이 같은가 확인
		if (vo.getPwd().equals(c_pwd)) {
			result = "same";
		}
		
		Map map = new HashMap();
		map.put("result", result);
		
		return map;
		
		//Json으로 포장하여 전송 {"result":"same"}
		//String resultStr = String.format("{\"result\":\"%s\"}", result);
		//return resultStr;
	}
	
	
	
	@RequestMapping("/visit/json/insert.do")
	@ResponseBody
	public Map insert(VisitVo vo,HttpServletRequest request) {
		// visit/insert.do?name=홍길동&content=내용&pwd=123
		//인자(수)로 객체를 선언하면 Spring에서 파라메터받고
		//객체로 포장해서 전달해준다
		
		String ip = request.getRemoteAddr();
		// '\n' => '<br>'로 변경(엔터)
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
		// '\n' => '<br>'로 변경(엔터)
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
