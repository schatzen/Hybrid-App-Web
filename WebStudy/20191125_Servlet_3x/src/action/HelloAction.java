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
			HttpServletRequest  request,//요청처리객체 
			HttpServletResponse response//응답처리객체
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//                   ?name=value&name1=value1.. <= Query
		//               함수(변수명=값) <= parameter(인자,인수)
		//http://.../hello.do?nation=kor
		//                   ?nation=eng
		//                   ?nation=chn
		//                   ?nation=jpn
		//http://.../hello.do
		//http://.../hello.do?nation=
		
		
		//클라이언트가 요청한 정보(Parameter)를 얻어오기
		String nation = request.getParameter("nation");
		
		//parameter 안들어오거나 값이 없는경우
		if(nation==null || nation.isEmpty())
			nation="kor";
		
		String greet_msg="";
		
		switch(nation)
		{
			case "kor": greet_msg = "[kor]안녕하세요"; break;
			case "eng": greet_msg = "[eng]Hi Everyone!!"; break;
			case "chn": greet_msg = "[chn]니하오 마~"; break;
			case "jpn": greet_msg = "[jpn]오겡끼데스까"; break;
			case "ger": greet_msg = "[ger]당케쉔"; break;
			case "fra": greet_msg = "[fra]봉쥬르"; break;
			default: greet_msg = String.format("[%s]뭘까?",nation);
		}
				
		
		//request : 클라이언트 정보 담겨져 있다
		String ip = request.getRemoteAddr();//클라이언트 IP정보
		
		System.out.println("--action.HelloAction Call--"+ ip);
		
		//response : 응답처리객체
		//클라이언트에게 현재 전송되는 Content정보 알려줘야 한다
		response.setContentType("text/html; charset=utf-8;");
		
		//전송(응답)객체
		PrintWriter out = response.getWriter();
		
		//동적으로 HTML생성 전송
		out.print("<html>");
		out.print("<head><title>인사말</title></head>");
		out.print("<body>");
		out.printf("[%s]님 %s<br>",ip,greet_msg);
		out.print("<a href='greet.html'>다시하기</a>");
		out.print("</body>");
		out.print("</html>");
		
		
		
		
	}

}
