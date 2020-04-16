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
          
		//0.���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// /visit/insert.do?name=ȫ�浿&content=�ȳ�&pwd=1234
		//1.parameter�ޱ�
		String name 	= request.getParameter("name");
		String content 	= request.getParameter("content");
		String pwd 		= request.getParameter("pwd");
		// �ۼ��� ip
		String ip		= request.getRemoteAddr();
		
		// \n -> <br>����
		content = content.replaceAll("\n", "<br>");
		
		//2.VisitVo����: �������ڸ� ��Ƽ� ó��
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		//3.DB Insert
		int res = VisitDao.getInstance().insert(vo);
		
		//4.����Ʈ ����� �̵�
		response.sendRedirect("list.do");			
			
		

		
	}
}