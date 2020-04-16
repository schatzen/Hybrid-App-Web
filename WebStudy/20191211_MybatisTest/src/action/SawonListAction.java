package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/list.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// sawon/list.do?deptno=10
		
		int deptno = 0;
		String str_deptno = request.getParameter("deptno");
		if(str_deptno!=null)
			deptno = Integer.parseInt(str_deptno);
		
		
        //사원목록 가져오기
		List<SawonVo> list = null;
		
		if(deptno==0)//전체조회
		     list = SawonDao.getInstance().selectList();
		else //부서별조회
			 list = SawonDao.getInstance().selectList(deptno);
		
		//System.out.println(list.size());
		
		//request binding
		request.setAttribute("list", list);
				
		//dispatcher(forward)
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}