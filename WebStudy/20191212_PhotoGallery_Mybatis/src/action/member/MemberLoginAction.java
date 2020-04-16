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
		
		//0.�������ڵ�
		request.setCharacterEncoding("utf-8");
		
		//1.parameter�ޱ�
		String id  = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2.id�� �ش�Ǵ� ȸ������ ���ϱ�
		MemberVo  user = MemberDao.getInstance().selectOne(id);
		
		//id�� Ʋ�����
		if(user==null) { 
			
			response.sendRedirect("login_form.do?reason=fail_id");
			return;
		}
		
		//��й�ȣ�� Ʋ�����
		if(user.getPwd().equals(pwd)==false) {
			
			response.sendRedirect("login_form.do?reason=fail_pwd");
			return;
		}
		
		//�α��� ����=>���� �α��� ���¸� ���ǿ� ����(MemberVo)
		HttpSession  session = request.getSession();
		//session binding
		session.setAttribute("user", user);
		
		//������������ �̵�
		response.sendRedirect("../photo/list.do");
		
		
		
		
		
	}
}





