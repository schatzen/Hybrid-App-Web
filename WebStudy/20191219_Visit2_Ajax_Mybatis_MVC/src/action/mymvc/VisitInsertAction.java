package action.mymvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class VisitInsertAction {

	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		// /visit/insert.do?name=�ȱ浿&content=lorem&pwd=1234
		// 1.PARAMETER �ޱ�
		String name    = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd     = request.getParameter("pwd");
		
		// �ۼ��� IP �ޱ�(getRemoteAddr�̿�)
		String ip = request.getRemoteAddr();
		
		// '\n' => '<br>'�� ����(����)
		content = content.replaceAll("\n", "<br>");
		
		// 2.visitVo�� ���� (�������ڸ� ��Ƽ� ó���ϱ� ���� vo�� �������ش�)
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		// 3.DB INSERT
		int res = VisitDao.getInstance().insert(vo);
		
		return "redirect:list.do";
	}
}
