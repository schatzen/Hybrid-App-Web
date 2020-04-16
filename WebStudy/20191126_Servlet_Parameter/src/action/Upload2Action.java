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
@WebServlet("/upload2.do")
public class Upload2Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//클라이언트 측에서 multipart/form-data로 전송시에는
		//MultipartRequest로 Parameter를 수신해야 된다
		
		//화일업로드 위치
		//String save_dir="c:\\MyStudy\\upload";
		String web_path="/upload/";
		String save_dir="";
		//ServletContext(웹컨텍스트(프로그램)관리하기 위한 전역객체)정보를 구함
		ServletContext application = request.getServletContext();
		//웹상대경로->절대경로 구하기
		save_dir = application.getRealPath(web_path);
		System.out.println(save_dir);
		
				
		int max_size = 1024 * 1024 * 100;//업로드 크기 설정
		//              1KB    1MB 
		
		//객체생성=>화일업로드 완료
		MultipartRequest mr = new MultipartRequest(
				                request, //request로부터 위임
				                save_dir,//upload된 화일 저장위치 
				                max_size,//upload 최대크기 
				                "utf-8", //수신인코딩
				                //동일화일명이 존재하면 이름을 바꿔서 저장
				                new DefaultFileRenamePolicy()
				                );
		
		//업로드된 화일과 같이전송된 Parameter받기
		// => MultipartRequest로 받아야 된다
		String title = mr.getParameter("title");
		//System.out.println(title);
		
		//상대 클라이언트의 IP정보 수신
		String ip = request.getRemoteAddr();
		
		//업로드된 화일정보 구하기
		
		/*
		//방법1)
		//원래화일명 
		String original_filename = mr.getOriginalFileName("photo");
		String filename1 = mr.getFilesystemName("photo");
		System.out.printf("원본:%s  업로드된 화일:%s\n",
				         original_filename,filename1);
	    */
		
		//방법2)
		//                   parameter name
		File  f1 = mr.getFile("photo1");
		//System.out.println(f);
		String filename1="";
		if(f1 != null) {//업로드가 되었으면
			
			//실제업로드된 화일명
			filename1 = f1.getName();
			//System.out.println(filename);
		}
		
		File  f2 = mr.getFile("photo2");
		//System.out.println(f);
		String filename2="";
		if(f2 != null) {//업로드가 되었으면
			
			//실제업로드된 화일명
			filename2 = f2.getName();
			//System.out.println(filename);
		}
		
		
		//String html = String.format("<img src='%s\\%s'>",save_dir,filename);
		//System.out.println(html);
		
		//수신내용 응답
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.printf("제목:%s<br>", title);
		out.printf("<img src='upload/%s' width='200'>",filename1);
		out.printf("<img src='upload/%s' width='200'>",filename2);
		out.printf("<br><a href='fileupload_input2.html'>다시하기</a>");
		
				
			
		
	}

}
