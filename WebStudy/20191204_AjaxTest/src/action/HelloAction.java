package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("--HelloAction call--");
		
		// hello.do?nation=�ѱ�
		
		request.setCharacterEncoding("utf-8");
		String nation = request.getParameter("nation");
		if(nation==null)
			nation="�ѱ�";
		
		//System.out.println(nation);
		String greet_message="";
		
		switch(nation)
		{
		   case "�ѱ�": greet_message = "[�ѱ�] �ȳ��ϼ���";break;
		   case "�̱�": greet_message = "[�̱�] Hi~~";break;
		   case "�߱�": greet_message = "[�߱�] ���Ͽ�~~";break;
		   case "�Ϻ�": greet_message = "[�Ϻ�] ���۳�������~~";break;
		   case "����": greet_message = "[����] ���ɽ�~~";break;
		   case "������": greet_message = "[������] ���긣~~";break;
		   default: greet_message = String.format("[%s]���� �λ縻�� �����?", nation);
		}
		
		//��� ����
		response.setContentType("text/plain; charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.print(greet_message);
				
		
		
	}
}
