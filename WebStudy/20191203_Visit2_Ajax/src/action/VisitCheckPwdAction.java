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
 * Servlet implementation class VisitCheckPwdAction
 */
@WebServlet("/visit/check_pwd.do")
public class VisitCheckPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /visit/check_pwd.do?idx=11&c_pwd=1111
		
		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		//idx에 해당되는 게시물얻어
		VisitVo  vo = VisitDao.getInstance().selectOne(idx);
		
		String result = "diff";
		//게시물 비번과 내가 입력비번 확인
		if(vo.getPwd().equals(c_pwd)) {
		   result = "same";	
		}  
		
		//JSON으로 포장 : {"result":"same"}
		String resultStr 
		     = String.format("{\"result\":\"%s\"}", result);
		
		
		//전송
		response.setContentType("text/plain; charset=utf-8;");
		response.getWriter().print(resultStr);
		
		
		
	}
}