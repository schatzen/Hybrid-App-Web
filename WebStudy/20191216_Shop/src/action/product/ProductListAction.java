package action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.ProductVo;

/**
 * Servlet implementation class ProductListAction
 */
@WebServlet("/shop/list.do")
public class ProductListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        //수신인코딩
		request.setCharacterEncoding("utf-8");
		
		// shop/list.do?category=sp003
		//카테고리 수신
		String category = request.getParameter("category");
		if(category==null)
			  category = "com001";
		
		List<ProductVo> list = ProductDao.getInstance().selectList(category);		
		
		//System.out.println(list.size());
		
		//request binding
		request.setAttribute("list", list);
		
		//dispatcher(forward)
		String forward_page = "product_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}