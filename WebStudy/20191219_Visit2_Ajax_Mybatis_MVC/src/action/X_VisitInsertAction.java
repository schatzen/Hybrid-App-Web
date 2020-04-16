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
		// 0.���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// /visit/insert.do?name=�ȱ浿&content=lorem&pwd=1234
		// 1.PARAMETER �ޱ�
		String name    = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd     = request.getParameter("pwd");
		
		// �ۼ��� IP �ޱ�(getRemoteAddr�̿�)
		String ip = request.getRemoteAddr();
		
		// '\n' => '<br>'�� ����(����)
		content = content.replaceAll("\n", "<br>");
		
		// 2.visitVo�� ���� (�������ڸ� ��Ƽ� ó���ϱ� ���� vo�� �������ش�)
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		// 3.DB INSERT
		int res = VisitDao.getInstance().insert(vo);
		
		// 4.List ����� �̵�
		response.sendRedirect("list.do");

	}
}
