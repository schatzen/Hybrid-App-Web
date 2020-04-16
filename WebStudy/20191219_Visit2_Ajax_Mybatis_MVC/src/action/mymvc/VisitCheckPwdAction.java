package action.mymvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class VisitCheckPwdAction {

	public String execute(HttpServletRequest request,
			               HttpServletResponse response) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd"); 
		
		//idx에 해당되는 게시물얻어오기
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String result = "diff";
		//게시물 비번과 내가 입력한 비번이 같은가 확인
		if (vo.getPwd().equals(c_pwd)) {
			result = "same";
		}
		
		//Json으로 포장하여 전송 {"result":"same"}
		String resultStr = String.format("{\"result\":\"%s\"}", result);
		
		//전송
		//response.setContentType("text/plain; chraset=utf-8;");
		//response.getWriter().print(resultStr);
		return "responseBody:" + resultStr; 
		
		//request.setAttribute("resultStr", resultStr);
		//return "result_check_pwd.jsp";
	}
}
