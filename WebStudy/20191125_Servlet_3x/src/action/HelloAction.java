package action;

import java.io.IOException;
import java.io.PrintWriter;

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
	protected void service(
			HttpServletRequest  request,//��ûó����ü 
			HttpServletResponse response//����ó����ü
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//                   ?name=value&name1=value1.. <= Query
		//               �Լ�(������=��) <= parameter(����,�μ�)
		//http://.../hello.do?nation=kor
		//                   ?nation=eng
		//                   ?nation=chn
		//                   ?nation=jpn
		//http://.../hello.do
		//http://.../hello.do?nation=
		
		
		//Ŭ���̾�Ʈ�� ��û�� ����(Parameter)�� ������
		String nation = request.getParameter("nation");
		
		//parameter �ȵ����ų� ���� ���°��
		if(nation==null || nation.isEmpty())
			nation="kor";
		
		String greet_msg="";
		
		switch(nation)
		{
			case "kor": greet_msg = "[kor]�ȳ��ϼ���"; break;
			case "eng": greet_msg = "[eng]Hi Everyone!!"; break;
			case "chn": greet_msg = "[chn]���Ͽ� ��~"; break;
			case "jpn": greet_msg = "[jpn]���۳�������"; break;
			case "ger": greet_msg = "[ger]���ɽ�"; break;
			case "fra": greet_msg = "[fra]���긣"; break;
			default: greet_msg = String.format("[%s]����?",nation);
		}
				
		
		//request : Ŭ���̾�Ʈ ���� ����� �ִ�
		String ip = request.getRemoteAddr();//Ŭ���̾�Ʈ IP����
		
		System.out.println("--action.HelloAction Call--"+ ip);
		
		//response : ����ó����ü
		//Ŭ���̾�Ʈ���� ���� ���۵Ǵ� Content���� �˷���� �Ѵ�
		response.setContentType("text/html; charset=utf-8;");
		
		//����(����)��ü
		PrintWriter out = response.getWriter();
		
		//�������� HTML���� ����
		out.print("<html>");
		out.print("<head><title>�λ縻</title></head>");
		out.print("<body>");
		out.printf("[%s]�� %s<br>",ip,greet_msg);
		out.print("<a href='greet.html'>�ٽ��ϱ�</a>");
		out.print("</body>");
		out.print("</html>");
		
		
		
		
	}

}
