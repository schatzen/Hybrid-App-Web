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
		
		//세션에 저장된 로그인된 회원의 m_idx
		MemberVo user = (MemberVo) request.getSession().getAttribute("user");
		
		//로그아웃상태면
		if(user==null) {
			response.sendRedirect("../member/login_form.do?reason=fail_cart");
			return;
		}
		
		//로그인 유저의 idx를 구함
		int m_idx = user.getIdx();
		
		//로그인 유저의 장바구니 목록
		List<CartVo> list = CartDao.getInstance().selectList(m_idx);
		//장바구니 총액
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