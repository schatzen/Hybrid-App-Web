package action.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberInsertAction
 */
@WebServlet("/member/insert.do")
public class MemberInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        // /member/insert.do?name=ȫ���&id=hong&pwd=1234&zipcode=04108&addr=����+������+����+4&grade=�Ϲ�
		//0.�������ڵ�
		request.setCharacterEncoding("utf-8");
		
		//1.parameter�ޱ�
		String name 	= request.getParameter("name");
		String id   	= request.getParameter("id");
		String pwd  	= request.getParameter("pwd");
		String zipcode 	= request.getParameter("zipcode");
		String addr 	= request.getParameter("addr");
		String grade 	= request.getParameter("grade");
		// ip�ޱ�
		String ip		= request.getRemoteAddr();
		
		//2.MemberVo����
		MemberVo vo = new MemberVo(name, id, pwd, zipcode, addr, ip, grade);
		
		//3.DB insert
		int res = MemberDao.getInstance().insert(vo);
		
		//4.ȸ����Ϻ���
		response.sendRedirect("list.do");
		
	}
}






