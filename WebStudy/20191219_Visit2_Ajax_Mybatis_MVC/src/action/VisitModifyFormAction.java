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
 * Servlet implementation class VisitModifyFormAction
 */
@WebServlet("/visit/modify_form.do")
public class VisitModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		///visit/modify_form.do?idx12
		//1.수정할 IDX번호 얻어오기 
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//2.IDX에 해당되는 데이터 1건 얻어오기
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);
				
		//3.request binding
		request.setAttribute("vo", vo);
		
		//dispatcher(forward)
		String forward_page = "visit_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}
