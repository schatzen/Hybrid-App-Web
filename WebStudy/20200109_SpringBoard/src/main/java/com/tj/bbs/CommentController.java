package com.tj.bbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CommentDao;
import myutil.MyConstant;
import myutil.Paging;
import vo.CommentVo;

@Controller
public class CommentController {

	
	@Autowired
	HttpServletRequest request;

	
	CommentDao comment_dao;

	public void setComment_dao(CommentDao comment_dao) {
		this.comment_dao = comment_dao;
	}
	
	// /comment/list.do?b_idx=63&page=1
	@RequestMapping("/comment/list.do")
	public String list(int b_idx,Integer page,Model model) {
		
		int nowPage=1;
		if(page!=null) nowPage = page;
		
		//b_idx에 달린 댓글의 총갯수
		int rowTotal = comment_dao.selectRowTotal(b_idx);

		
		int start = (nowPage-1)* MyConstant.Comment.BLOCKLIST + 1;
		int end   =    start   + MyConstant.Comment.BLOCKLIST - 1;
		
		Map map = new HashMap();
		map.put("b_idx", b_idx);
		map.put("start", start);
		map.put("end", end);
		
		
		List<CommentVo> list = comment_dao.selectList(map);
		
		//Paging Menu생성
		String pageMenu = Paging.getCommentPaging(
				                       nowPage, 
				                       rowTotal, 
				                       MyConstant.Comment.BLOCKLIST, 
				                       MyConstant.Comment.BLOCKPAGE
				                       );
		
		
		model.addAttribute("list", list);
		
		if(rowTotal>0)
		   model.addAttribute("pageMenu", pageMenu);
				
		return "board/board_comment_list";
	}
	
	///insert.do?content=내용&m_idx=4&m_name=홍길동&b_idx=52
	@RequestMapping("/comment/insert.do")
	@ResponseBody
	public Map insert(CommentVo vo) {
		
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		int res = comment_dao.insert(vo);
		
		//처리결과
		String result = (res==1) ? "success" : "fail";
		
		Map map = new HashMap();
		
		map.put("result", result);
		
		//map=> {"result":"success"}
		
		return map;
	}
	
	
	@RequestMapping("/comment/delete.do")
	@ResponseBody
	public Map delete(int idx) {
		
		int res = comment_dao.delete(idx);
		
		//처리결과
		String result = (res==1) ? "success" : "fail";
		
		Map map = new HashMap();
		
		map.put("result", result);
		
		//map=> {"result":"success"}
		
		return map;
	}
	
	
	
}
