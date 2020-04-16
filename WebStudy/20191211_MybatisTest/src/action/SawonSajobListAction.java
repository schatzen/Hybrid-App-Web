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
 * Servlet implementation class SawonSajobListAction
 */
@WebServlet("/sawon/sajob_list.do")
public class SawonSajobListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /sawon/sajob_list.do
		// /sawon/sajob_list.do?sajob=all
		// /sawon/sajob_list.do?sajob=부장
			
		request.setCharacterEncoding("utf-8");
		String sajob = request.getParameter("sajob");
		if(sajob==null) sajob="all";
		
		
        //사원목록 가져오기
		List<SawonVo> list = null;
		
		if(sajob.equals("all"))
			list = SawonDao.getInstance().selectList();
		else
			list = SawonDao.getInstance().selectList(sajob);
		
		//System.out.println(list.size());
		
		//request binding
		request.setAttribute("list", list);
				
		//dispatcher(forward)
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}