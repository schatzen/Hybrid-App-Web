package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// calc.do?su1=11&su2=22
		
		//1.parameter 받기
		String str_su1 = request.getParameter("su1");
		String str_su2 = request.getParameter("su2");
		//2.정수로 변환
		int su1 = Integer.parseInt(str_su1);
		int su2 = Integer.parseInt(str_su2);
		//결과 생성->전송
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>계산결과</title></head>");
		out.print("<body>");
		out.print("::::계산결과::::<br>");
		out.printf("%d + %d = %d<br>",su1,su2, su1+su2);
		out.printf("%d - %d = %d<br>",su1,su2, su1-su2);
		out.printf("%d * %d = %d<br>",su1,su2, su1*su2);
		out.printf("%d / %d = %d<br>", su1,su2, su2==0 ? 0 : su1/su2);
		out.printf("%d %% %d = %d<br>",su1,su2, su2==0 ? 0 : su1%su2);
		
		out.print("<a href='calc.html'>다시하기</a>"); 
		out.print("</body>");
		out.print("</html>");
		
		
		
		
	}

}
