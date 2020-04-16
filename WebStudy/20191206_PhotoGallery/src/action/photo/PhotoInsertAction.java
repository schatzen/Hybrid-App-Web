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
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.MemberVo;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoInsertAction
 */
@WebServlet("/photo/insert.do")
public class PhotoInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String web_path="/upload/";
		String save_dir="";
		//ServletContext(�����ؽ�Ʈ(���α׷�)�����ϱ� ���� ������ü)������ ����
		ServletContext application = request.getServletContext();
		//�������->������ ���ϱ�
		save_dir = application.getRealPath(web_path);
		System.out.println(save_dir);
				
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
		String p_subject = mr.getParameter("p_subject");
		String p_content = mr.getParameter("p_content");
		//System.out.println(title);
		
		//��� Ŭ���̾�Ʈ�� IP���� ����
		String p_ip = request.getRemoteAddr();
		
		//                   parameter name
		File  f = mr.getFile("photo");
		//System.out.println(f);
		String p_filename="";
		if(f != null) {//���ε尡 �Ǿ�����
			
			//�������ε�� ȭ�ϸ�
			p_filename = f.getName();
			//System.out.println(filename);
		}
		
		//���� �ø������ m_idx���ϱ�(���ǿ� ����� ���� �о����)
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		int m_idx = user.getIdx();
		
		
		//PhotoVo����
		PhotoVo vo = new PhotoVo(m_idx, p_subject, p_content, p_filename, p_ip);
		
		//DB Insert
		int res = PhotoDao.getInstance().insert(vo);
		
		//��Ϻ���
		response.sendRedirect("list.do");
					
		
	}
}