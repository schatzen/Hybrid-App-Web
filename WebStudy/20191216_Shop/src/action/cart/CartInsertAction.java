package action.cart;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;

/**
 * Servlet implementation class CartInsertAction
 */
@WebServlet("/shop/cart_insert.do")
public class CartInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        //  /shop/cart_insert.do?p_idx=22&m_idx=4
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		CartVo vo = new CartVo();
		vo.setP_idx(p_idx);
		vo.setM_idx(m_idx);
		
		CartVo resVo = CartDao.getInstance().selectOne(vo);
		
		boolean result = false;//�⺻��:����
		
		if(resVo==null) {//��ٱ��Ͽ� ��ϵ� ��ǰ������ ����...
		  
			//��ٱ��Ͽ� ���
			int res = CartDao.getInstance().insert(vo);
			
			result = true;//����
		}
		//                              {"result":true }
		String jsonStr = String.format("{\"result\":%b}", result);
		
		
		//��� �뺸
		response.setContentType("text/plain; charset=utf-8;");
		response.getWriter().print(jsonStr);
		
		
	}
}