package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyListAction {

	// /mytest/list.do
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		//forward view page : 내부에서 /WEB-INF/접근가능
		//return "/WEB-INF/views/mytest/my_list.jsp";
		return "my_list.jsp";
	}
}
