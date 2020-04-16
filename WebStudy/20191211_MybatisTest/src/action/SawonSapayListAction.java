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
@WebServlet("/sawon/sapay_list.do")
public class SawonSapayListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// sawon/sapay_list.do
		// sawon/sapay_list.do?min_pay=2000&max_pay=3000
		
		String str_min_pay = request.getParameter("min_pay");
		String str_max_pay = request.getParameter("max_pay");
		int min_pay = 0;
		int max_pay = 0;
		
		if(str_min_pay!=null)
			min_pay = Integer.parseInt(str_min_pay);
		
		if(str_max_pay!=null)
			max_pay = Integer.parseInt(str_max_pay);
				
		//Mybatis�� 2���̻��� Parameter�� ������ ���
		//Map���� �����ؼ� �ѱ��
		Map map = new HashMap();
		//        key      value
		map.put("min_pay", min_pay);
		map.put("max_pay", max_pay);
				
        //������ ��������
		List<SawonVo> list = null;
		
		if(min_pay==0)//��ü��ȸ
		     list = SawonDao.getInstance().selectList();
		else //�޿��� ��ȸ
			 list = SawonDao.getInstance().selectList(map);
		
		//System.out.println(list.size());
		
		//request binding
		request.setAttribute("list", list);
				
		//dispatcher(forward)
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}