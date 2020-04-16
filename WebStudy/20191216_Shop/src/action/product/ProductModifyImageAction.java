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
@WebServlet("/shop/modify_image.do")
public class ProductModifyImageAction extends HttpServlet {
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
		int    idx          = Integer.parseInt(mr.getParameter("idx"));
        String image_size   = mr.getParameter("image_size");
		
        ProductVo  vo = ProductDao.getInstance().selectOne(idx);
        
        String del_filename="";
        if(image_size.equals("small")) {
	        //                   parameter name
			File  f = mr.getFile("p_image_s");
			String p_image_s="";
			if(f != null) {//���ε尡 �Ǿ�����
				//�������ε�� ȭ�ϸ�
				del_filename = vo.getP_image_s();
				p_image_s = f.getName();
				vo.setP_image_s(p_image_s);
				
				//System.out.printf("[%s]:[%s]\n",p_image_s,del_filename);
				
			}
        }else if(image_size.equals("large")) {
	        //                   parameter name
			File  f = mr.getFile("p_image_l");
			String p_image_l="";
			if(f != null) {//���ε尡 �Ǿ�����
				//�������ε�� ȭ�ϸ�
				del_filename = vo.getP_image_l();
				p_image_l = f.getName();
				vo.setP_image_l(p_image_l);
			}
        }
        
        //����ȭ�� ����
        File ff = new File(save_dir, del_filename);
        ff.delete();
        
        //DB����
        int res = ProductDao.getInstance().update_filename(vo);
        
        boolean bResult = true;
		//��� JSON ��ȯ
        String resultJson = String.format("{\"result\":%b}", bResult);
        
        response.setContentType("text/plain; charset=utf-8;");
        response.getWriter().print(resultJson);
				
	}
}




