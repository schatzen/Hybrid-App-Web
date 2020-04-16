package action.mymvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;

public class VisitDeleteAction {

	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		//  /visit/delete.do?idx=13
		//삭제할 idx 수신
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//DB delete
	    int res = VisitDao.getInstance().delete(idx);
		
		return "redirect:list.do";
	}
}
