package action.photo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoOneAction
 */
@WebServlet("/photo/photo_one.do")
public class PhotoOneAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		
		String jsonStr = 
				String.format("{\"p_subject\":\"%s\",\"p_content\":\"%s\",\"p_filename\":\"%s\" }", 
				                       vo.getP_subject(),
				                       vo.getP_content(),
				                       vo.getP_filename()
				);
		
		response.setContentType("text/plain; charset=utf-8;");
		response.getWriter().print(jsonStr);
		
		
		
		

		
	}
}






