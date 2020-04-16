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
		
		//idx�ش�Ǵ� �Խù� 1�� ���
		ProductVo vo = ProductDao.getInstance().selectOne(idx);
		//������ ȭ�ϸ�
		String p_image_s  = vo.getP_image_s();
		String p_image_l  = vo.getP_image_l();
		
		//����������ġ(������)
		String path = request.getServletContext().getRealPath("/images/");
		System.out.println(path);
		
		//�����̹��� ����
		File f = new File(path, p_image_s);
		f.delete();
		
		//ū�̹��� ����
		f = new File(path, p_image_l);
		f.delete();
		
		
		//DB delete
		int res = ProductDao.getInstance().delete(idx);
		
		//�ش� ī�װ� ��� �̵�	
		response.sendRedirect("list.do?category=" + vo.getCategory());
		
		
		
		
		
	}
}