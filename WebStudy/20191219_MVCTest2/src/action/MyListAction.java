package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyListAction {

	// /mytest/list.do
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		//forward view page : ���ο��� /WEB-INF/���ٰ���
		//return "/WEB-INF/views/mytest/my_list.jsp";
		return "my_list.jsp";
	}
}
