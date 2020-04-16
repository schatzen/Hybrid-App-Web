package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitListAction
 */
//@WebServlet("/visit/list.do")
public class X_VisitListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// /list.do
		// /list.do?search=all&search_text=길동
		// /list.do?search=name&search_text=길동
		// /list.do?search=content&search_text=길동
		// /list.do?search=name_content&search_text=길동
		
		// 0.수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		String search = request.getParameter("search");
		String search_text = request.getParameter("search_text");
		
		if (search == null) {
			search = "all";
		}
		
		// 검색 정보를 담을 객체 생성
		Map map = new HashMap();
		
		// 전체검색이 아닌경우
		if (search.equals("all") == false) {
			
			// name+content
			if (search.equals("name_content")) {
				
				map.put("name", search_text);
				map.put("content", search_text);
				
			// name
			} else if (search.equals("name")) {
				
				map.put("name", search_text);
				
			// content
			} else if (search.equals("content")) {
				
				map.put("content", search_text);
				
			}
		}
		
		
		//방명록 목록 가져오기
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		//REQUEST BINDING
		request.setAttribute("list", list);
				
		//dispatcher(forward)
		String forward_page = "visit_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}
