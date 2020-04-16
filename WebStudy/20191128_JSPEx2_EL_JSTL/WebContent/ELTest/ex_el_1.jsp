<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
   EL(Expression Language):표현언어
   1.JSP내에 값을 출력하는 언어
   2.각영역에 저장된값
     (pageScope,requestScope,sessionScope,applicationScope)
     URL로 넘어오는 Parameter값만 표현할 수 있다
     (?menu=intro)=> ${ param.menu == 'intro' }
     
   3.형식)
     ${ 영역이름.값 }
     영역명 생략가능 : 참조순서
     pageScope->requestScope->sessionScope->applicationScope   
     ${ 값 } 

--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
  EL연산자
<hr>
산술연산자: + - * / %<br>
\${ 1 + 1 } => ${ 1 + 1 }<br>
\${ 5 - 1 } => ${ 5 - 1 }<br>
\${ 3 * 2 } => ${ 3 * 2 }<br>
\${ 10 / 3 } => ${ 10 / 3 }<br>
\${ 10 % 3 } => ${ 10 % 3  }<br>

<br>
<%--
   관계연산자:  >(gt)  >=(ge) < (lt) <= (le)
                ==(eq) !=(ne) 
--%>
\${ 3>2 }   => ${ 3>2  } or ${ 3 gt 2 }<br>
\${ 3>=2 }  => ${ 3>=2 } or ${ 3 ge 2 }<br>
\${ 3< 2 }  => ${ 3<2  } or ${ 3 lt 2 }<br>
\${ 3<=2 }  => ${ 3<=2 } or ${ 3 le 2 }<br>
\${ 3==2 }  => ${ 3==2 } or ${ 3 eq 2 }<br>
\${ 3!=2 }  => ${ 3!=2 } <%-- or ${ 3 ne 2 } --%><br>

<!-- 삼항연산자 -->
\${ 3 > 0 ? '양수':'음수' } => ${ 3 > 0 ? '양수':'음수' }

<hr>
논리연산자: &&(and)  ||(or)  !(not)
<hr>
\${ true && true }   =>${ true && true } or ${ true and true }<br>
\${ (3>2) || (5<0) } =>${ (3>2) || (5<0) } or ${ (3>2) or (5<0) }<br>
\${ !(3>2) } => ${ !(3>2) } or ${ not (3>2) }<br>


</body>
</html>