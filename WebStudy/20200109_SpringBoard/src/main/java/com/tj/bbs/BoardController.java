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

	//@Autowired <= ���� �־��ֳ�?
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
	// /board/list.do?search=name&search_text=�浿
	// /board/list.do?page=2
	

	@RequestMapping("/board/list.do")
	public String list(Integer page,String search,String search_text,Model model) {
		
		int nowPage = 1;//���� ������
		if(page!=null)
			nowPage = page;
		
		// BLOCKLIST = 5
		//����/��
		int start = (nowPage-1)* MyConstant.Board.BLOCKLIST + 1;
		int end   =    start   + MyConstant.Board.BLOCKLIST - 1;
		
		//�˻�������/������ ���� ��ü
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		//�˻�ī�װ��� ������ ��ü�˻�
		if(search==null) search="all";
		if(search_text==null) search_text="";
		
		//��ü�˻��� �ƴϸ�...
		if(!search.equals("all")) {
			
			//����+�̸�+����
			if(search.equals("subject_name_content")) {
				
				map.put("subject", search_text);
				map.put("name", search_text);
				map.put("content", search_text);
				
			}else if(search.equals("subject")) {
				//����
				map.put("subject", search_text);
			}else if(search.equals("name")) {
				//�̸�
				map.put("name", search_text);
			}else if(search.equals("content")) {
				//����
				map.put("content", search_text);
			}
		}		
		
		//�Խù� �Ѱ��� ���ϱ�
		int rowTotal = board_dao.selectRowTotal(map);
		//System.out.println(rowTotal);
				
		List<BoardVo> list = board_dao.selectList(map);
		
		
		//�˻�filter
		String search_filter = 
			String.format("list.do?search=%s&search_text=%s", 
					            search,     search_text);
		
		//pageMenu����
		String pageMenu = Paging.getPaging(
				                    search_filter, 
				                    nowPage, 
				                    rowTotal, 
				                    MyConstant.Board.BLOCKLIST, 
				                    MyConstant.Board.BLOCKPAGE
				                    );
		
		//System.out.println(pageMenu);
		//System.out.println(list.size());
		
		//������ �ôٴ� ������ �����
		session.removeAttribute("show");
		
		
		//model���� request binding
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return "board/board_list";
	}
	
	
	@RequestMapping("/board/view.do")
	public String view(int idx,Model model) {
		
		BoardVo vo = board_dao.selectOne(idx);
		
		//���ǿ� ���� �Խù��� �óĶ�� ������ Ȯ��(show)
		if(session.getAttribute("show")==null) {
		
			//��ȸ�� ����
			int res = board_dao.update_readhit(idx);
			
			//�ôٶ�� ���� ���
			session.setAttribute("show",true);
		}
		
		
		//��������δ� request biding
		model.addAttribute("vo", vo);
		
		return "board/board_view";
	}
	
	//�۾��� �� ����
	@RequestMapping("/board/insert_form.do")
	public String insert_form() {
		
		return "board/board_insert_form";
	}
	
	//��۾��� �� ����
	@RequestMapping("/board/reply_form.do")
	public String reply_form() {
		
		return "board/board_reply_form";
	}
	
	
	//�۾���
	// /board/insert.do?m_idx=4&subject=����&m_name=ȫ�浿&content=����
	@RequestMapping("/board/insert.do")
	public String insert(BoardVo vo) {
		//              DispatcherServlet�� Parameter�ް� Vo����
		
		//�ۼ��� IP
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		int res = board_dao.insert(vo);
		
		
		
		return "redirect:list.do";
	}
	
	
	//��۾���
	// board/reply.do?m_idx=4&idx=4&subject=aaa&m_name=ȫ�浿&content=aaa
	@RequestMapping("/board/reply.do")
	public String reply(BoardVo vo,int page,Model model) {
		//              DispatcherServlet�� Parameter�ް� Vo����
		
		//���ر����� ������
		BoardVo baseVo = board_dao.selectOne(vo.getIdx());
		
		//���ر۱׷���߿��� ���رۺ��� step�� 
		//ū�Խù����� step�� 1�� ����
		int res  = board_dao.update_step(baseVo);
		
		//�ۼ��� IP
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		//������� ����
		vo.setRef(baseVo.getRef());      //���ر� ref 
		vo.setStep(baseVo.getStep()+1);  //���ر� step  + 1
		vo.setDepth(baseVo.getDepth()+1);//���ر� depth + 1
		
		
		res = board_dao.reply(vo);
		
		// redirect�ÿ� parameter�� ���
		model.addAttribute("page", page);
		
		return "redirect:list.do";// list.do?page=3
	}
	
	// delete.do?idx=${vo.idx}&page=${ param.page }&search=${ param.search}&search_text=${ param.search_text }
	@RequestMapping("/board/delete.do")
	public String delete(int idx,int page,String search,String search_text,Model model) {
		
		int res = board_dao.delete(idx);
		
		//idx�� �޸� ��� ����
		res = comment_dao.delete_all(idx);
		
		
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		
		return "redirect:list.do";//list.do?page=2&search=name&search_text=�浿
	}
	
	
	
	//���� �� ����
	@RequestMapping("/board/modify_form.do")
	public String modify_form(int idx,Model model) {
		
		BoardVo  vo = board_dao.selectOne(idx);
		
		model.addAttribute("vo", vo);
				
		return "board/board_modify_form";
	}
	
	//����
	@RequestMapping("/board/modify.do")
	public String modify(BoardVo vo,int page,String search,String search_text,Model model) {
		
		//�ۼ��� IP
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







