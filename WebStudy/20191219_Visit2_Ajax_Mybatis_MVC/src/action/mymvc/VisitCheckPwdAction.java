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
		
		//idx�� �ش�Ǵ� �Խù�������
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String result = "diff";
		//�Խù� ����� ���� �Է��� ����� ������ Ȯ��
		if (vo.getPwd().equals(c_pwd)) {
			result = "same";
		}
		
		//Json���� �����Ͽ� ���� {"result":"same"}
		String resultStr = String.format("{\"result\":\"%s\"}", result);
		
		//����
		//response.setContentType("text/plain; chraset=utf-8;");
		//response.getWriter().print(resultStr);
		return "responseBody:" + resultStr; 
		
		//request.setAttribute("resultStr", resultStr);
		//return "result_check_pwd.jsp";
	}
}
