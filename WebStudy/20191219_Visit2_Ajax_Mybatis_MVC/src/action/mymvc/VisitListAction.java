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
		
		//�˻������� ���� ��ü
		Map map = new HashMap();
		
		//��ü�˻��� �ƴϸ�...
		if(search.equals("all")==false) {
			//�̸�+����
			if(search.equals("name_content")) {
				map.put("name", search_text);
				map.put("content", search_text);
			}else if(search.equals("name")) {
				//�̸�
				map.put("name", search_text);
			}else if(search.equals("content")) {
				//����
				map.put("content", search_text);
			}
		}
		
		//1.���� ��� ��������
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		//2.request binding
		request.setAttribute("list", list);
		
		
		return "visit_list.jsp";
	}
}
