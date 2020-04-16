package action.mymvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;

public class VisitInsertFormAction {

	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		
		return "visit_insert_form.jsp";
	}
}
