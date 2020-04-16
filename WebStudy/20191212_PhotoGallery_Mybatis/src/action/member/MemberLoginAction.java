package action.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do")
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /member/login.do?id=hong&pwd=1234
		
		//0.수신인코딩
		request.setCharacterEncoding("utf-8");
		
		//1.parameter받기
		String id  = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2.id에 해당되는 회원정보 구하기
		MemberVo  user = MemberDao.getInstance().selectOne(id);
		
		//id가 틀린경우
		if(user==null) { 
			
			response.sendRedirect("login_form.do?reason=fail_id");
			return;
		}
		
		//비밀번호가 틀린경우
		if(user.getPwd().equals(pwd)==false) {
			
			response.sendRedirect("login_form.do?reason=fail_pwd");
			return;
		}
		
		//로그인 성공=>현재 로그인 상태를 세션에 저장(MemberVo)
		HttpSession  session = request.getSession();
		//session binding
		session.setAttribute("user", user);
		
		//메인페이지로 이동
		response.sendRedirect("../photo/list.do");
		
		
		
		
		
	}
}





