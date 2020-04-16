<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    System.out.println("a.jsp-> dispatcher:b.jsp");
  
    //이동할 페이지 설정
    RequestDispatcher disp = 
    		request.getRequestDispatcher("b.jsp");
    //서버내부에서 호출
    //현재 갖고있는 request,response그대로 전달
    disp.forward(request,response);

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>