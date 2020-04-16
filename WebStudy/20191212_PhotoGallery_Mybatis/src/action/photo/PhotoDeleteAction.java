package action.photo;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoDeleteAction
 */
@WebServlet("/photo/delete.do")
public class PhotoDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������ �Խù� ��ȣ(p_idx)
        int p_idx = Integer.parseInt(request.getParameter("p_idx")) ;
        
        //ȭ�ϻ����� ���ؼ� �ش�Խù����� 1�� ���
        PhotoVo  vo = PhotoDao.getInstance().selectOne(p_idx);
        
        //������ ���ϱ�
        String web_path="/upload/";
		String save_dir="";
		//ServletContext(�����ؽ�Ʈ(���α׷�)�����ϱ� ���� ������ü)������ ����
		ServletContext application = request.getServletContext();
		//�������->������ ���ϱ�
		save_dir = application.getRealPath(web_path);
		
		//ȭ�ϻ���
		File  f = new File(save_dir, vo.getP_filename());
		f.delete();
		
		//DB delete
		int res = PhotoDao.getInstance().delete(p_idx);
		
		//������� ..
		response.sendRedirect("list.do");
		
        		
		
		
	}
}



