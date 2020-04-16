package action.product;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.ProductVo;

/**
 * Servlet implementation class ProductModifyFormAction
 */
@WebServlet("/shop/modify_form.do")
public class ProductModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        // //shop/modify_form.do?idx=22
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		ProductVo  vo = ProductDao.getInstance().selectOne(idx);
		
		request.setAttribute("vo", vo);
				
		//dispatcher(forward)
		String forward_page = "product_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}





