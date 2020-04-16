package action.product;

import java.io.File;
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
 * Servlet implementation class ProductDeleteAction
 */
@WebServlet("/shop/delete.do")
public class ProductDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /shop/delete.do?idx=4&category=ele002
		
		int idx 		= Integer.parseInt(request.getParameter("idx"));
		String category = request.getParameter("category");
		
		//idx해당되는 게시물 1건 얻기
		ProductVo vo = ProductDao.getInstance().selectOne(idx);
		//삭제할 화일명
		String p_image_s  = vo.getP_image_s();
		String p_image_l  = vo.getP_image_l();
		
		//파일저장위치(절대경로)
		String path = request.getServletContext().getRealPath("/images/");
		System.out.println(path);
		
		//작은이미지 삭제
		File f = new File(path, p_image_s);
		f.delete();
		
		//큰이미지 삭제
		f = new File(path, p_image_l);
		f.delete();
		
		
		//DB delete
		int res = ProductDao.getInstance().delete(idx);
		
		//해당 카테고리 목록 이동	
		response.sendRedirect("list.do?category=" + vo.getCategory());
		
		
		
		
		
	}
}