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
		
		
		//������ �������� Jumin��ü Ȱ��
		Jumin jumin = new Jumin();
		jumin.setJumin_no(jumin_no);
		
		int year 		= jumin.getYear();
		int age  		= jumin.getAge();
		String tti 		= jumin.getTti();
		String season 	= jumin.getSeason();
		String local	= jumin.getLocal();
		String ganji	= jumin.getGanji();
		String gender	= jumin.getGender();
		
		//���۰�ü ������
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		//���䳻�� �ۼ�
		StringBuffer sb = new StringBuffer();
		sb.append("<table border='1'>");
		
		sb.append("<tr><th>�ֹι�ȣ</th><td>");
		sb.append(jumin_no);
		sb.append("</td></tr>");
		
		sb.append("<tr><th>����⵵</th><td>");
		sb.append(String.format("%d(%s)",year,ganji));
		sb.append("</td></tr>");
		
		sb.append("<tr><th>����</th><td>");
		sb.append(age);
		sb.append("</td></tr>");
		
		sb.append("<tr><th>��</th><td>");
		sb.append(tti);
		sb.append("</td></tr>");
		
		sb.append("<tr><th>����</th><td>");
		sb.append(gender);
		sb.append("</td></tr>");
		
		sb.append("<tr><th>�������</th><td>");
		sb.append(local);
		sb.append("</td></tr>");
		
		sb.append("<tr><th>�������</th><td>");
		sb.append(season);
		sb.append("</td></tr>");
		
		sb.append("<tr><td colspan='2'><a href='jumin.html'>�ٽ��ϱ�</a></td></tr>");
		sb.append("</table>");
		
		//�������
		out.print(sb.toString());
		
		
		
		
		
		
		
	}

}
