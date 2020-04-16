package action.product;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import vo.ProductVo;

/**
 * Servlet implementation class ProductInsertAction
 */
@WebServlet("/shop/insert.do")
public class ProductInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String web_path="/images/";
		String save_dir="";
		//ServletContext(�����ؽ�Ʈ(���α׷�)�����ϱ� ���� ������ü)������ ����
		ServletContext application = request.getServletContext();
		//�������->������ ���ϱ�
		save_dir = application.getRealPath(web_path);
						
		int max_size = 1024 * 1024 * 100;//���ε� ũ�� ����
		//              1KB    1MB 
		
		//��ü����=>ȭ�Ͼ��ε� �Ϸ�
		MultipartRequest mr = new MultipartRequest(
				                request, //request�κ��� ����
				                save_dir,//upload�� ȭ�� ������ġ 
				                max_size,//upload �ִ�ũ�� 
				                "utf-8", //�������ڵ�
				                //����ȭ�ϸ��� �����ϸ� �̸��� �ٲ㼭 ����
				                new DefaultFileRenamePolicy()
				                );
		
		//���ε�� ȭ�ϰ� �������۵� Parameter�ޱ�
		// => MultipartRequest�� �޾ƾ� �ȴ�
		String category 	= mr.getParameter("category");
		String p_num 		= mr.getParameter("p_num");
		String p_name 		= mr.getParameter("p_name");
		String p_company	= mr.getParameter("p_company");
		String p_content	= mr.getParameter("p_content");
		int    p_price		= Integer.parseInt(mr.getParameter("p_price"));
		int    p_saleprice	= Integer.parseInt(mr.getParameter("p_saleprice"));
		
		//                   parameter name
		File  f = mr.getFile("p_image_s");
		String p_image_s="";
		if(f != null) {//���ε尡 �Ǿ�����
			//�������ε�� ȭ�ϸ�
			p_image_s = f.getName();
		}
		
		//p_image_s = mr.getFilesystemName("p_image_s");
		
		f = mr.getFile("p_image_l");
		String p_image_l="";
		if(f != null) {//���ε尡 �Ǿ�����
			//�������ε�� ȭ�ϸ�
			p_image_l = f.getName();
		}
		
		ProductVo  vo = new ProductVo(category, p_num, p_name, p_company, p_price, p_saleprice, p_image_s, p_image_l, p_content);

		int res = ProductDao.getInstance().insert(vo);
		
		//����ȭ������ �̵�
		response.sendRedirect("list.do?category=" + category);
		
	}
}




