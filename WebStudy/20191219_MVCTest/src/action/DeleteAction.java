package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAction {

	public String execute(
			HttpServletRequest request,
			HttpServletResponse response) {
		
		// delete.do?book=Java
		String book = request.getParameter("book");
		System.out.println(book + " 삭제완료!!");
		
		return "redirect:list.do";
	}
}
