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
		String p_subject = mr.getParameter("p_subject");
		String p_content = mr.getParameter("p_content");
		//System.out.println(title);
		
		//상대 클라이언트의 IP정보 수신
		String p_ip = request.getRemoteAddr();
		
		//                   parameter name
		File  f = mr.getFile("photo");
		//System.out.println(f);
		String p_filename="";
		if(f != null) {//업로드가 되었으면
			
			//실제업로드된 화일명
			p_filename = f.getName();
			//System.out.println(filename);
		}
		
		//사진 올린사용자 m_idx구하기(세션에 저장된 정보 읽어오기)
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		int m_idx = user.getIdx();
		
		
		//PhotoVo포장
		PhotoVo vo = new PhotoVo(m_idx, p_subject, p_content, p_filename, p_ip);
		
		//DB Insert
		int res = PhotoDao.getInstance().insert(vo);
		
		//목록보기
		response.sendRedirect("list.do");
					
		
	}
}