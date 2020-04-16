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
		
		//1.parameter �ޱ�
		String str_su1 = request.getParameter("su1");
		String str_su2 = request.getParameter("su2");
		//2.������ ��ȯ
		int su1 = Integer.parseInt(str_su1);
		int su2 = Integer.parseInt(str_su2);
		//��� ����->����
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>�����</title></head>");
		out.print("<body>");
		out.print("::::�����::::<br>");
		out.printf("%d + %d = %d<br>",su1,su2, su1+su2);
		out.printf("%d - %d = %d<br>",su1,su2, su1-su2);
		out.printf("%d * %d = %d<br>",su1,su2, su1*su2);
		out.printf("%d / %d = %d<br>", su1,su2, su2==0 ? 0 : su1/su2);
		out.printf("%d %% %d = %d<br>",su1,su2, su2==0 ? 0 : su1%su2);
		
		out.print("<a href='calc.html'>�ٽ��ϱ�</a>"); 
		out.print("</body>");
		out.print("</html>");
		
		
		
		
	}

}
