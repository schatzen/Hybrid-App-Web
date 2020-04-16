package action.mymvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class VisitListAction {

	public String execute(HttpServletRequest request,HttpServletResponse response) {
		//System.out.println("--action.mymvc.VisitListAction--");
		String search 		= request.getParameter("search");
		String search_text 	= request.getParameter("search_text");
		
		if(search==null) search="all";
		
		//검색정보를 담을 객체
		Map map = new HashMap();
		
		//전체검색이 아니면...
		if(search.equals("all")==false) {
			//이름+내용
			if(search.equals("name_content")) {
				map.put("name", search_text);
				map.put("content", search_text);
			}else if(search.equals("name")) {
				//이름
				map.put("name", search_text);
			}else if(search.equals("content")) {
				//내용
				map.put("content", search_text);
			}
		}
		
		//1.방명록 목록 가져오기
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		//2.request binding
		request.setAttribute("list", list);
		
		
		return "visit_list.jsp";
	}
}
