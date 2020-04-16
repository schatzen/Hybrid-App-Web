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
		  case "kor": nation_name="�ѱ�";
		              greet_message="�ȳ��ϼ���";
		              break;
		  case "eng": nation_name="�̱�/����";
			          greet_message="Hi~ Everyone!!";
			          break;
		  case "chn": nation_name="�߱�";
			          greet_message="���Ͽ���~~";
			          break;			          
		  case "jpn": nation_name="�Ϻ�";
			          greet_message="���۳�������";
			          break;	          
          default:  nation_name="������ ����";
                    greet_message="����?"; 
		}
		
		//request binding
		//Java�� ��� ��ü�� ���� �� �ִ�
		
		request.setAttribute("nation_name", nation_name);
		request.setAttribute("greet_message", greet_message);
				
		
		// �� Bisiness Logic
		
//--------------------------------------------------------		
		//dispatcher(forward)
		String forward_page = "hello.jsp";
		RequestDispatcher disp 
		    = request.getRequestDispatcher(forward_page);
		// request,response �״�� ����
		disp.forward(request, response);
	}
}
