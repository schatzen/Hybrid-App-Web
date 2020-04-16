package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//http://localhost:9090/20191125_Servlet_2x/hello.do
		// protocol://ip     :port/     path          /content   
		//http://192.168.0.20:9090/20191125_Servlet_2x/hello.do
		
		//����� 2.x�� ����ȣ�� ���� /WEB-INF/web.xml�� ���� ���
		
		//��û�� ����(IP)
		String ip = request.getRemoteAddr();
		
		System.out.println("--HelloAction: Call[" + ip + "]--" );
				
	}

}
