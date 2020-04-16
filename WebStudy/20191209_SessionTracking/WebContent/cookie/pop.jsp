<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   //최근 방문했던 페이지 정보를 쿠키에서 얻어온다
   Cookie [] cookie_array = request.getCookies();
   
   StringBuffer sb = new StringBuffer("[최근방문페이지]<br>");
   
   if(cookie_array!=null){
       
	   
	   for(Cookie cookie1 : cookie_array){
		  
		   String name = cookie1.getName();
		   //System.out.println(name);
		   if(name.equals("JSESSIONID")==false){
			   String value = cookie1.getValue();
			   sb.append(
					   String.format("<a href='%s'>%s</a><br>",value,name)
			           );
		   }
	   }
	   	   
   }

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  #disp{
     width: 150px;
     height: 200px;
     background-color: gray;
     color: white;
     position: absolute;
     top: 50px;
     right: 50px;
     padding: 20px;
  }
  
  a{
     text-decoration: none;
     color: blue;
     font-size: 20px;
  }
  
</style>
</head>
<body>
  <div id="disp"><%= sb.toString() %></div>
</body>
</html>