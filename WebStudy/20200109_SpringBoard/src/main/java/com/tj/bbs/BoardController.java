package com.tj.bbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BoardDao;
import dao.CommentDao;
import myutil.MyConstant;
import myutil.Paging;
import vo.BoardVo;

@Controller
public class BoardController {

	//@Autowired <= 누가 넣어주나?
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	
	BoardDao   board_dao;
	CommentDao comment_dao;
	
	
	public void setBoard_dao(BoardDao board_dao) {
		this.board_dao = board_dao;
	}
	
	public void setComment_dao(CommentDao comment_dao) {
		this.comment_dao = comment_dao;
	}
	// /board/list.do
	// /board/list.do?search=name&search_text=길동
	// /board/list.do?page=2
	

	@RequestMapping("/board/list.do")
	public String list(Integer page,String search,String search_text,Model model) {
		
		int nowPage = 1;//현재 페이지
		if(page!=null)
			nowPage = page;
		
		// BLOCKLIST = 5
		//시작/끝
		int start = (nowPage-1)* MyConstant.Board.BLOCKLIST + 1;
		int end   =    start   + MyConstant.Board.BLOCKLIST - 1;
		
		//검색페이지/조건을 담을 객체
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		//검색카테고리가 없으면 전체검색
		if(search==null) search="all";
		if(search_text==null) search_text="";
		
		//전체검색이 아니면...
		if(!search.equals("all")) {
			
			//제목+이름+내용
			if(search.equals("subject_name_content")) {
				
				map.put("subject", search_text);
				map.put("name", search_text);
				map.put("content", search_text);
				
			}else if(search.equals("subject")) {
				//제목
				map.put("subject", search_text);
			}else if(search.equals("name")) {
				//이름
				map.put("name", search_text);
			}else if(search.equals("content")) {
				//내용
				map.put("content", search_text);
			}
		}		
		
		//게시물 총갯수 구하기
		int rowTotal = board_dao.selectRowTotal(map);
		//System.out.println(rowTotal);
				
		List<BoardVo> list = board_dao.selectList(map);
		
		
		//검색filter
		String search_filter = 
			String.format("list.do?search=%s&search_text=%s", 
					            search,     search_text);
		
		//pageMenu생성
		String pageMenu = Paging.getPaging(
				                    search_filter, 
				                    nowPage, 
				                    rowTotal, 
				                    MyConstant.Board.BLOCKLIST, 
				                    MyConstant.Board.BLOCKPAGE
				                    );
		
		//System.out.println(pageMenu);
		//System.out.println(list.size());
		
		//이전에 봤다는 정보를 지우기
		session.removeAttribute("show");
		
		
		//model통한 request binding
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return "board/board_list";
	}
	
	
	@RequestMapping("/board/view.do")
	public String view(int idx,Model model) {
		
		BoardVo vo = board_dao.selectOne(idx);
		
		//세션에 현재 게시물을 봤냐라는 정보를 확인(show)
		if(session.getAttribute("show")==null) {
		
			//조회수 증가
			int res = board_dao.update_readhit(idx);
			
			//봤다라는 정보 기록
			session.setAttribute("show",true);
		}
		
		
		//결과적으로는 request biding
		model.addAttribute("vo", vo);
		
		return "board/board_view";
	}
	
	//글쓰기 폼 띄우기
	@RequestMapping("/board/insert_form.do")
	public String insert_form() {
		
		return "board/board_insert_form";
	}
	
	//답글쓰기 폼 띄우기
	@RequestMapping("/board/reply_form.do")
	public String reply_form() {
		
		return "board/board_reply_form";
	}
	
	
	//글쓰기
	// /board/insert.do?m_idx=4&subject=제목&m_name=홍길동&content=내용
	@RequestMapping("/board/insert.do")
	public String insert(BoardVo vo) {
		//              DispatcherServlet이 Parameter받고 Vo포장
		
		//작성자 IP
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		int res = board_dao.insert(vo);
		
		
		
		return "redirect:list.do";
	}
	
	
	//답글쓰기
	// board/reply.do?m_idx=4&idx=4&subject=aaa&m_name=홍길동&content=aaa
	@RequestMapping("/board/reply.do")
	public String reply(BoardVo vo,int page,Model model) {
		//              DispatcherServlet이 Parameter받고 Vo포장
		
		//기준글정보 얻어오기
		BoardVo baseVo = board_dao.selectOne(vo.getIdx());
		
		//기준글그룹글중에서 기준글보다 step이 
		//큰게시물들은 step을 1씩 증가
		int res  = board_dao.update_step(baseVo);
		
		//작성자 IP
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		//답글정보 설정
		vo.setRef(baseVo.getRef());      //기준글 ref 
		vo.setStep(baseVo.getStep()+1);  //기준글 step  + 1
		vo.setDepth(baseVo.getDepth()+1);//기준글 depth + 1
		
		
		res = board_dao.reply(vo);
		
		// redirect시에 parameter로 사용
		model.addAttribute("page", page);
		
		return "redirect:list.do";// list.do?page=3
	}
	
	// delete.do?idx=${vo.idx}&page=${ param.page }&search=${ param.search}&search_text=${ param.search_text }
	@RequestMapping("/board/delete.do")
	public String delete(int idx,int page,String search,String search_text,Model model) {
		
		int res = board_dao.delete(idx);
		
		//idx에 달린 댓글 삭제
		res = comment_dao.delete_all(idx);
		
		
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		
		return "redirect:list.do";//list.do?page=2&search=name&search_text=길동
	}
	
	
	
	//수정 폼 띄우기
	@RequestMapping("/board/modify_form.do")
	public String modify_form(int idx,Model model) {
		
		BoardVo  vo = board_dao.selectOne(idx);
		
		model.addAttribute("vo", vo);
				
		return "board/board_modify_form";
	}
	
	//수정
	@RequestMapping("/board/modify.do")
	public String modify(BoardVo vo,int page,String search,String search_text,Model model) {
		
		//작성자 IP
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		int res = board_dao.update(vo);
		
		model.addAttribute("idx", vo.getIdx());
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		
			
		return "redirect:view.do";
	}
	
	
}







