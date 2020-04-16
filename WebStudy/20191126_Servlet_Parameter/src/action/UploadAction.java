package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadAction
 */
@WebServlet("/upload.do")
public class UploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Ŭ���̾�Ʈ ������ multipart/form-data�� ���۽ÿ���
		//MultipartRequest�� Parameter�� �����ؾ� �ȴ�
		
		//ȭ�Ͼ��ε� ��ġ
		//String save_dir="c:\\MyStudy\\upload";
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
		String title = mr.getParameter("title");
		//System.out.println(title);
		
		//��� Ŭ���̾�Ʈ�� IP���� ����
		String ip = request.getRemoteAddr();
		
		//���ε�� ȭ������ ���ϱ�
		
		/*
		//���1)
		//����ȭ�ϸ� 
		String original_filename = mr.getOriginalFileName("photo");
		String filename1 = mr.getFilesystemName("photo");
		System.out.printf("����:%s  ���ε�� ȭ��:%s\n",
				         original_filename,filename1);
	    */
		
		//���2)
		//                   parameter name
		File  f = mr.getFile("photo");
		//System.out.println(f);
		String filename="";
		if(f != null) {//���ε尡 �Ǿ�����
			
			//�������ε�� ȭ�ϸ�
			filename = f.getName();
			//System.out.println(filename);
		}
		
		//String html = String.format("<img src='%s\\%s'>",save_dir,filename);
		//System.out.println(html);
		
		//���ų��� ����
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.printf("����:%s<br>", title);
		out.printf("<img src='upload/%s' width='200'><br>",filename);
		out.printf("<a href='fileupload_input.html'>�ٽ��ϱ�</a>");
		
				
			
		
	}

}
