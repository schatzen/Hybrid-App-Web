
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    
      
	//_jspService(request,response)내부작성
	
	//MemberRegisterAction 참조
	
	//1.수신인코딩설정
	//2.Parameter받기
	//3.Data가공(취미/친구/비밀번호 Mask)
	
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
%>
<!--  Business Logic: Data Process Logic  -->

<!-- ----------------------------------------------- -->

<!--  Presentation Logic: 화면출력 Logic-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 수신받은 데이터 테이블 형식으로 출력 -->
<table border="1" width="300">
  <tr>
  	<th>이름</th>
  	<td><%= name %></td>
  </tr>

  <tr>
  	<th>아이디</th>
  	<td><%= id %></td>
  </tr>
  
  <tr>
  	<th>비밀번호</th>
  	<td><%= pwd_mask %></td>
  </tr>
  
  <tr>
  	<th>성별</th>
  	<td><%= gender %></td>
  </tr>
  
  <tr>
  	<th>혈액형</th>
  	<td><%= blood %></td>
  </tr>
  
  <tr>
  	<th>취미</th>
  	<td><%= hobby_list %></td>
  </tr>
  
  <tr>
  	<th>친구</th>
  	<td><%= friend_list %></td>
  </tr>
  
  <tr>
  	<th>자기소개</th>
  	<td><%= profile %></td>
  </tr>
  
  <tr>
  	<td colspan="2" align="center">
  	   
  	   <!-- javascript location 객체는 페이지 이동시 사용 --> 
  	   <input type="button" value="다시하기" 
  	          onclick="javascript:location.href='member_input.html'">
  	</td>
  </tr>
  
</table>






</body>
</html>


