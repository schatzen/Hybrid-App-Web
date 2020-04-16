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
		//ServletContext(웹컨텍스트(프로그램)관리하기 위한 전역객체)정보를 구함
		ServletContext application = request.getServletContext();
		//웹상대경로->절대경로 구하기
		save_dir = application.getRealPath(web_path);
						
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
		if(f != null) {//업로드가 되었으면
			//실제업로드된 화일명
			p_image_s = f.getName();
		}
		
		//p_image_s = mr.getFilesystemName("p_image_s");
		
		f = mr.getFile("p_image_l");
		String p_image_l="";
		if(f != null) {//업로드가 되었으면
			//실제업로드된 화일명
			p_image_l = f.getName();
		}
		
		ProductVo  vo = new ProductVo(category, p_num, p_name, p_company, p_price, p_saleprice, p_image_s, p_image_l, p_content);

		int res = ProductDao.getInstance().insert(vo);
		
		//메인화면으로 이동
		response.sendRedirect("list.do?category=" + category);
		
	}
}




