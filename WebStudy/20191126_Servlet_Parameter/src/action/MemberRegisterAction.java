package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register.do")
public class MemberRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request,//��ûó����ü(Ŭ���̾�Ʈ������) 
			HttpServletResponse response
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//                  ?parametername=value& 
		//member_register.do?name=ȫ�浿&id=hong&pwd=1234&
		//                   gender=����&
		//                   friend=&friend=&friend=&
		//                   blood=A&profile=���� ����?
		
		//    üũ�ڽ��� üũ�� �׸� �Ѿ�´�
		//member_register.do?name=ȫ�浿&id=hong&pwd=1234&gender=����&
		//                   hobby=����&hobby=����&
		//                   friend=&friend=&friend=&
		//                   blood=A&profile=����+����%3F
		
		
		//0.�������ڵ� ����(POST������� ���۽ÿ��� ������ ����)
		request.setCharacterEncoding("utf-8");
		
		//Web Parameter�� String���� �Ѿ�´�
		String name 	= request.getParameter("name");
		String id		= request.getParameter("id");
		String pwd  	= request.getParameter("pwd");
		String gender 	= request.getParameter("gender");
		String blood	= request.getParameter("blood");
		String profile	= request.getParameter("profile");
		
		// \n -> <br> ��ȯ
		profile = profile.replaceAll("\n", "<br>");
		
		
		//���
		String [] hobby_array = request.getParameterValues("hobby");
		String hobby_list="��̾���";
		if(hobby_array!=null) {
			
			StringBuffer sb = new StringBuffer();
			// hobby_array = {"����","����"};
			for(String hobby : hobby_array) {
				sb.append(hobby);
				sb.append(" ");
			}
			hobby_list = sb.toString().trim();//"���� ����"
		}
		
		//ģ��
		String [] friend_array = request.getParameterValues("friend");
		//   friend_array={"","",""};
		StringBuffer sb1 = new StringBuffer();
		for(String friend: friend_array) {
			sb1.append(friend);
			sb1.append(" ");
		}
		
		String friend_list=sb1.toString().trim(); //""
		if(friend_list.isEmpty())
			friend_list="ģ������";
		
		//��й�ȣ Mask
		int len = pwd.length();
		StringBuffer sb2 = new StringBuffer();
		sb2.append(pwd.substring(0, len/2));
		for(int i=0;i<len-len/2;i++) {
			sb2.append("*");
		}
		String pwd_mask = sb2.toString();
		
		//System.out.println(pwd_mask);
		
		//Business Logic: Data Process Logic
//-----------------------------------------------------------------		
		//Presentation Logic: ȭ����� Logic
		
		// �Է°���� ����     
		// mime-type => image/jpg , text/xml , text/json   
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		
		out.print("<table border='1' align='center' width='300'>");
		out.printf("<tr><th width='100'>�̸�</th><td>%s</td></tr>", name);
		out.printf("<tr><th>���̵�</th><td>%s</td></tr>", id);
		out.printf("<tr><th>��й�ȣ</th><td>%s</td></tr>", pwd_mask);
		out.printf("<tr><th>����</th><td>%s</td></tr>", gender);
		out.printf("<tr><th>������</th><td>%s</td></tr>", blood);
		out.printf("<tr><th>���</th><td>%s</td></tr>", hobby_list);
		out.printf("<tr><th>ģ��</th><td>%s</td></tr>", friend_list);
		out.printf("<tr><th>�ڱ�Ұ�</th><td>%s</td></tr>", profile);
		out.printf("<tr><td colspan='2' align='center'><a href='member_input.html'>�ٽ��ϱ�</a></td></tr>");
		out.print("</table>");
		
		
		
		
		
		
	}
}
