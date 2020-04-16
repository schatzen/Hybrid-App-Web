package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.NaverSearchUtil;
import vo.BookVo;

/**
 * Servlet implementation class BookSearchAction
 */
@WebServlet("/book_search.do")
public class BookSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /book_search.do?book_name=자바&start=1&display=10
		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.도서명 받기
		String book_name = request.getParameter("book_name");
		
		if(book_name==null) book_name="java";
		
		int start  =Integer.parseInt(request.getParameter("start"));  //최대 1000
		int display=Integer.parseInt(request.getParameter("display"));//최대 100
		
		//도서검색 요청
		List<BookVo> list=null;
		try {
			list = NaverSearchUtil.search_book(book_name, start, display);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request binding
		request.setAttribute("list", list);
				
		//dispatcher(forward)
		String forward_page = "book_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}