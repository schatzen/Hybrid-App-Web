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
 * Servlet implementation class ProductModifyAction
 */
@WebServlet("/shop/modify.do")
public class ProductModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        ///shop/modify.do?idx=21
		//                category=ele002
		//                p_num=vC-13
		//                p_name=사니PDP-TV
		//                p_company=사니
		//                p_price=9200
		//                p_saleprice=4750
		//                p_content=질러~ 질러 후회 하지 않아~~
		
		request.setCharacterEncoding("utf-8");
		
		int    idx 			= Integer.parseInt(request.getParameter("idx"));
		String category 	= request.getParameter("category");
		String p_num		= request.getParameter("p_num");
		String p_name		= request.getParameter("p_name");
		String p_company	= request.getParameter("p_company");
		int    p_price		= Integer.parseInt(request.getParameter("p_price"));
		int    p_saleprice	= Integer.parseInt(request.getParameter("p_saleprice"));
		String p_content	= request.getParameter("p_content");
		
		ProductVo  vo = new ProductVo(idx, category, p_num, p_name, p_company, p_price, p_saleprice, p_content);
		
		//DB Update
		int res = ProductDao.getInstance().update(vo);
		
		//수정후 해당 컨텐츠로 이동:view.do?idx=2
		response.sendRedirect("view.do?idx=" + idx);
				
		
		
		
	}
}