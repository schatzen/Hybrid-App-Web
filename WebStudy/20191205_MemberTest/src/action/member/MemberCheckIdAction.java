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
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /member/check_id.do?id=hong
		//0.�������ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//1.parameter�ޱ�
		String id = request.getParameter("id");
		
		//2.id�� �ش�Ǵ� ȸ������ ���´�
		MemberVo vo = MemberDao.getInstance().selectOne(id);
		
		boolean result = false;
		//id�� ����ϴ� ȸ�������� ����
		if(vo==null) result=true;
		
		String jsonStr = String.format("{\"result\":%b}", result);
		
		//�������
		response.setContentType("text/plain; charset=utf-8;");
		response.getWriter().print(jsonStr);
				
		
		
	}
}