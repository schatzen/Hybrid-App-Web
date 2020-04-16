package action;

import java.io.IOException;
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
	protected void service(
			HttpServletRequest  request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///20191128_JSPEx2_EL_JSTL/hello.do?nation=kor
		
		String nation = request.getParameter("nation");
		
	    if(nation==null)
	    	nation="kor";
		
		String nation_name="";
		String greet_message="";
		
		switch(nation)
		{
		  case "kor": nation_name="한국";
		              greet_message="안녕하세요";
		              break;
		  case "eng": nation_name="미국/영국";
			          greet_message="Hi~ Everyone!!";
			          break;
		  case "chn": nation_name="중국";
			          greet_message="니하오마~~";
			          break;			          
		  case "jpn": nation_name="일본";
			          greet_message="오겡끼데스까";
			          break;	          
          default:  nation_name="미지의 나라";
                    greet_message="뭐지?"; 
		}
		
		//request binding
		//Java의 모든 객체를 담을 수 있다
		
		request.setAttribute("nation_name", nation_name);
		request.setAttribute("greet_message", greet_message);
				
		
		// ↑ Bisiness Logic
		
//--------------------------------------------------------		
		//dispatcher(forward)
		String forward_page = "hello.jsp";
		RequestDispatcher disp 
		    = request.getRequestDispatcher(forward_page);
		// request,response 그대로 전달
		disp.forward(request, response);
	}
}
