package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAction {

	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		// view.do?book=Java
		
		String book = request.getParameter("book");
		
		String book_desc="";
		if(book.equalsIgnoreCase("java")) {
			book_desc = "Desktop Application���߿� ���";
		}else if(book.equalsIgnoreCase("jsp")) {
			book_desc = "Web Application���߿� ���";
		}else if(book.equalsIgnoreCase("oracle")) {
			book_desc = "Data�����ϴ� ���";
		}else if(book.equalsIgnoreCase("android")) {
			book_desc = "Google's Mobile ���";
		}else if(book.equalsIgnoreCase("ios")) {
			book_desc = "Apple's Mobile ���";
		}
		
		//request binding
		request.setAttribute("book", book);
		request.setAttribute("book_desc", book_desc);
			
		
		
		
		return "view.jsp";
	}
}
