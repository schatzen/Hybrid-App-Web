package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitInsertAction
 */
@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
          
		//0.수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// /visit/insert.do?name=홍길동&content=안녕&pwd=1234
		//1.parameter받기
		String name 	= request.getParameter("name");
		String content 	= request.getParameter("content");
		String pwd 		= request.getParameter("pwd");
		// 작성자 ip
		String ip		= request.getRemoteAddr();
		
		// \n -> <br>변경
		content = content.replaceAll("\n", "<br>");
		
		//2.VisitVo포장: 전달인자를 모아서 처리
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		//3.DB Insert
		int res = VisitDao.getInstance().insert(vo);
		
		//4.리스트 보기로 이동
		response.sendRedirect("list.do");			
			
		

		
	}
}