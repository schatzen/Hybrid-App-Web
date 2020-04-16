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
		
		// hello.do?nation=한국
		
		request.setCharacterEncoding("utf-8");
		String nation = request.getParameter("nation");
		if(nation==null)
			nation="한국";
		
		//System.out.println(nation);
		String greet_message="";
		
		switch(nation)
		{
		   case "한국": greet_message = "[한국] 안녕하세요";break;
		   case "미국": greet_message = "[미국] Hi~~";break;
		   case "중국": greet_message = "[중국] 니하오~~";break;
		   case "일본": greet_message = "[일본] 오겡끼데스까~~";break;
		   case "독일": greet_message = "[독일] 당케쉔~~";break;
		   case "프랑스": greet_message = "[프랑스] 봉쥬르~~";break;
		   default: greet_message = String.format("[%s]나라 인사말은 뭘까요?", nation);
		}
		
		//결과 응답
		response.setContentType("text/plain; charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.print(greet_message);
				
		
		
	}
}
