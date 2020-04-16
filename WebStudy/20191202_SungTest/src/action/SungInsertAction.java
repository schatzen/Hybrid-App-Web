package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungInsertAction
 */
@WebServlet("/sung/insert.do")
public class SungInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        //  sung/insert.do?name=ȫ�浿&kor=55&eng=66&mat=77
		//0.�������ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//1.parameter �ޱ�
		String name = request.getParameter("name");
		int    kor  = Integer.parseInt(request.getParameter("kor"));
		int    eng  = Integer.parseInt(request.getParameter("eng"));
		int    mat  = Integer.parseInt(request.getParameter("mat"));
		
		//2.SungVo����=>�������� ������ ��� ������ ����
		SungVo vo = new SungVo(name, kor, eng, mat);
		
		//3.DB insert
		int res = SungTBDao.getInstance().insert(vo); 
		
		
		//4.DB Insert�� ��Ϻ���� �̵�
		response.sendRedirect("list.do");
		
		
	}
}