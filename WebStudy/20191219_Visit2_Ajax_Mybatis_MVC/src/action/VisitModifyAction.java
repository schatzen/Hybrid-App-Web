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
 * Servlet implementation class VisitModifyAction
 */
@WebServlet("/visit/modify.do")
public class VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//0.수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.PARAMETER 받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		content = content.replaceAll("\n", "<br>");
		String pwd = request.getParameter("pwd");
		String regdate = request.getParameter("regdate");
		
		
		//2.Vo포장
		VisitVo vo = new VisitVo(idx, name, content, pwd, regdate);
		
		//3.DB INSERT
		int res = VisitDao.getInstance().update(vo);
		
		//4.목록
		response.sendRedirect("list.do");
	}
}