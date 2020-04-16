package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonSapayListAction
 */
@WebServlet("/sawon/sahire_list.do")
public class SawonSahireListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// sawon/sahire_list.do
		// sawon/sahire_list.do?start=1999&end=2000
		
		String str_start = request.getParameter("start");
		String str_end = request.getParameter("end");
		int start = 0;
		int end = 0;
		
		if(str_start!=null)
			start = Integer.parseInt(str_start);
		
		if(str_end!=null)
			end = Integer.parseInt(str_end);
				
		//Mybatis에 2개이상의 Parameter를 전달할 경우
		//Map으로 포장해서 넘긴다
		Map map = new HashMap();
		//        key      value
		map.put("start", start);
		map.put("end", end);
				
        //사원목록 가져오기
		List<SawonVo> list = null;
		
		if(start==0)//전체조회
		     list = SawonDao.getInstance().selectList();
		else //급여별 조회
			 list = SawonDao.getInstance().selectSahireList(map);
		
		//System.out.println(list.size());
		
		//request binding
		request.setAttribute("list", list);
				
		//dispatcher(forward)
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}