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
		//삭제할 게시물 번호(p_idx)
        int p_idx = Integer.parseInt(request.getParameter("p_idx")) ;
        
        //화일삭제를 위해서 해당게시물정보 1건 얻기
        PhotoVo  vo = PhotoDao.getInstance().selectOne(p_idx);
        
        //절대경로 구하기
        String web_path="/upload/";
		String save_dir="";
		//ServletContext(웹컨텍스트(프로그램)관리하기 위한 전역객체)정보를 구함
		ServletContext application = request.getServletContext();
		//웹상대경로->절대경로 구하기
		save_dir = application.getRealPath(web_path);
		
		//화일삭제
		File  f = new File(save_dir, vo.getP_filename());
		f.delete();
		
		//DB delete
		int res = PhotoDao.getInstance().delete(p_idx);
		
		//목록으로 ..
		response.sendRedirect("list.do");
		
        		
		
		
	}
}



