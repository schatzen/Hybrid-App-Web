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

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitListAction
 */
@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//visit/list.do
		//visit/list.do?search=all&search_text=
		//visit/list.do?search=name&search_text=�浿
		//visit/list.do?search=content&search_text=�浿
		//visit/list.do?search=name_content&search_text=�浿
		
		//0.�������ڵ�
		request.setCharacterEncoding("utf-8");
		
		String search 		= request.getParameter("search");
		String search_text 	= request.getParameter("search_text");
		
		if(search==null) search="all";
		
		//�˻������� ���� ��ü
		Map map = new HashMap();
		
		//��ü�˻��� �ƴϸ�...
		if(search.equals("all")==false) {
			//�̸�+����
			if(search.equals("name_content")) {
				map.put("name", search_text);
				map.put("content", search_text);
			}else if(search.equals("name")) {
				//�̸�
				map.put("name", search_text);
			}else if(search.equals("content")) {
				//����
				map.put("content", search_text);
			}
		}
				
		
		//1.���� ��� ��������
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
				
		
		
		//2.request binding
		request.setAttribute("list", list);

		//dispatcher(forward)
		String forward_page = "visit_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}