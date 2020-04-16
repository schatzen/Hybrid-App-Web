package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myutil.Jumin;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// jumin.do?jumin_no=801212-1234560
		
		String jumin_no = request.getParameter("jumin_no");
		//System.out.println(jumin_no);
		
		
		//이전에 만들어놓은 Jumin객체 활용
		Jumin jumin = new Jumin();
		jumin.setJumin_no(jumin_no);
		
		int year 		= jumin.getYear();
		int age  		= jumin.getAge();
		String tti 		= jumin.getTti();
		String season 	= jumin.getSeason();
		String local	= jumin.getLocal();
		//String ganji	= jumin.getGanji();
		String gender	= jumin.getGender();
		
		//JSON 생성
		StringBuffer sb = new StringBuffer("{") ;
		sb.append(String.format("\"year\":\"%d\",", year));
		sb.append(String.format("\"age\":\"%d\",", age));
		sb.append(String.format("\"tti\":\"%s\",", tti));
		sb.append(String.format("\"gender\":\"%s\",", gender));
		sb.append(String.format("\"season\":\"%s\",", season));
		sb.append(String.format("\"local\":\"%s\"", local));
		sb.append("}");
		
		//전송객체 얻어오기
		response.setContentType("text/plain; charset=utf-8;");
		response.getWriter().print(sb.toString());
		
		
		
		
		
		
		
		
	}

}
