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
			HttpServletRequest  request,//요청처리객체(클라이언트측정보) 
			HttpServletResponse response
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//                  ?parametername=value& 
		//member_register.do?name=홍길동&id=hong&pwd=1234&
		//                   gender=남자&
		//                   friend=&friend=&friend=&
		//                   blood=A&profile=나는 누구?
		
		//    체크박스는 체크된 항목만 넘어온다
		//member_register.do?name=홍길동&id=hong&pwd=1234&gender=남자&
		//                   hobby=독서&hobby=낚시&
		//                   friend=&friend=&friend=&
		//                   blood=A&profile=나는+누구%3F
		
		
		//0.수신인코딩 설정(POST방식으로 전송시에는 무조건 설정)
		request.setCharacterEncoding("utf-8");
		
		//Web Parameter는 String으로 넘어온다
		String name 	= request.getParameter("name");
		String id		= request.getParameter("id");
		String pwd  	= request.getParameter("pwd");
		String gender 	= request.getParameter("gender");
		String blood	= request.getParameter("blood");
		String profile	= request.getParameter("profile");
		
		// \n -> <br> 변환
		profile = profile.replaceAll("\n", "<br>");
		
		
		//취미
		String [] hobby_array = request.getParameterValues("hobby");
		String hobby_list="취미없음";
		if(hobby_array!=null) {
			
			StringBuffer sb = new StringBuffer();
			// hobby_array = {"독서","낚시"};
			for(String hobby : hobby_array) {
				sb.append(hobby);
				sb.append(" ");
			}
			hobby_list = sb.toString().trim();//"독서 낚시"
		}
		
		//친구
		String [] friend_array = request.getParameterValues("friend");
		//   friend_array={"","",""};
		StringBuffer sb1 = new StringBuffer();
		for(String friend: friend_array) {
			sb1.append(friend);
			sb1.append(" ");
		}
		
		String friend_list=sb1.toString().trim(); //""
		if(friend_list.isEmpty())
			friend_list="친구없음";
		
		//비밀번호 Mask
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
		//Presentation Logic: 화면출력 Logic
		
		// 입력결과를 응답     
		// mime-type => image/jpg , text/xml , text/json   
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		
		out.print("<table border='1' align='center' width='300'>");
		out.printf("<tr><th width='100'>이름</th><td>%s</td></tr>", name);
		out.printf("<tr><th>아이디</th><td>%s</td></tr>", id);
		out.printf("<tr><th>비밀번호</th><td>%s</td></tr>", pwd_mask);
		out.printf("<tr><th>성별</th><td>%s</td></tr>", gender);
		out.printf("<tr><th>혈액형</th><td>%s</td></tr>", blood);
		out.printf("<tr><th>취미</th><td>%s</td></tr>", hobby_list);
		out.printf("<tr><th>친구</th><td>%s</td></tr>", friend_list);
		out.printf("<tr><th>자기소개</th><td>%s</td></tr>", profile);
		out.printf("<tr><td colspan='2' align='center'><a href='member_input.html'>다시하기</a></td></tr>");
		out.print("</table>");
		
		
		
		
		
		
	}
}
