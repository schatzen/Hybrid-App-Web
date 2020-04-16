<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
     //JSP내장객체:외부에서는 보이지 않지만 내부에는 존재하는 객체
     //  request,response,session,application,pageContext,out,...

     ///20191127_JSPEx1/Test_gugudan.jsp?dan=7 
     String str_dan = request.getParameter("dan");

     int dan = 2;
     if(str_dan==null || str_dan.isEmpty())
    	 dan = 2;
     else
    	 dan = Integer.parseInt(str_dan);
     
     //접속자 정보 구하기
     String ip = request.getRemoteAddr();
     
     
     out.println( String.format("<h1>[%s]님 환영합니다</h1>", ip) );
     
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <hr>
   		<form > <!-- action속성이 생략되면 자신을 호출  -->
   		    <input type="radio" name="dan" value="2" checked="checked">2단
			<input type="radio" name="dan" value="3">3단
			<input type="radio" name="dan" value="4">4단
			<input type="radio" name="dan" value="5">5단
			<input type="radio" name="dan" value="6">6단
			<input type="radio" name="dan" value="7">7단
			<input type="radio" name="dan" value="8">8단
			<input type="radio" name="dan" value="9">9단
            <input type="submit"  value="보여줘">
   		</form>
    <hr>
	
	<table border="1" width="150" align="center">
	
	   <caption><%= dan %>단보기(<%= ip %>)</caption>
	   <!-- Html주석 : 서블릿변환시 그대로 들어간다  -->
	   <%-- JSP 주석 : 서블릿변환시 제외된다--%>
	   <%--
	         <%= 변수 or 값 %>
	         =>  out.print(변수 or 값); 
	              
	         cf) <%= 값; %>
	            => out.print(값;);    
	    --%>
	    
	   <%
	   		for(int i=1;i<=9;i++){
	   %> 
		   <tr>
		      <td><%= String.format("%d x %d = %d", dan,i,dan*i)  %></td>
		   </tr>
	   <%
	   		}//end-for
	   %>
	   
	   
	</table>
</body>
</html>