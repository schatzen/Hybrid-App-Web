package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitInserAction
 */
//@WebServlet("/visit/insert.do")
public class X_VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// /visit/insert.do?name=팔길동&content=lorem&pwd=1234
		// 1.PARAMETER 받기
		String name    = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd     = request.getParameter("pwd");
		
		// 작성자 IP 받기(getRemoteAddr이용)
		String ip = request.getRemoteAddr();
		
		// '\n' => '<br>'로 변경(엔터)
		content = content.replaceAll("\n", "<br>");
		
		// 2.visitVo로 포장 (전달인자를 모아서 처리하기 위해 vo에 포장해준다)
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		// 3.DB INSERT
		int res = VisitDao.getInstance().insert(vo);
		
		// 4.List 보기로 이동
		response.sendRedirect("list.do");

	}
}
