package action.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;
import vo.MemberVo;

/**
 * Servlet implementation class CartListAction
 */
@WebServlet("/shop/cart_list.do")
public class CartListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//���ǿ� ����� �α��ε� ȸ���� m_idx
		MemberVo user = (MemberVo) request.getSession().getAttribute("user");
		
		//�α׾ƿ����¸�
		if(user==null) {
			response.sendRedirect("../member/login_form.do?reason=fail_cart");
			return;
		}
		
		//�α��� ������ idx�� ����
		int m_idx = user.getIdx();
		
		//�α��� ������ ��ٱ��� ���
		List<CartVo> list = CartDao.getInstance().selectList(m_idx);
		//��ٱ��� �Ѿ�
		int total_amount = CartDao.getInstance().selectAmountTotal(m_idx);
		
		//request binding
		request.setAttribute("list", list);
		request.setAttribute("total_amount", total_amount);
				

		//dispatcher(forward)
		String forward_page = "cart_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}