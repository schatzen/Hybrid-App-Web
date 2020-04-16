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
 * Servlet implementation class VisitCheckPwdAction
 */
//@WebServlet("/visit/check_pwd.do")
public class X_VisitCheckPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//0.������ ����
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd"); 
		
		//idx�� �ش�Ǵ� �Խù�������
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String result = "diff";
		//�Խù� ����� ���� �Է��� ����� ������ Ȯ��
		if (vo.getPwd().equals(c_pwd)) {
			result = "same";
		}
		
		//Json���� �����Ͽ� ���� {"result":"same"}
		String resultStr = String.format("{\"result\":\"%s\"}", result);
		
		//����
		response.setContentType("text/plain; chraset=utf-8;");
		
		response.getWriter().print(resultStr);
		
	}
}