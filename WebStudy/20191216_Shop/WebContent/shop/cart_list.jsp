<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   
   function del(c_idx){
	   
	   if(confirm("정말 삭제하시겠습니까?")==false)return;
	   
	   location.href="cart_delete.do?c_idx=" + c_idx;
	   
   }
</script>


</head>
<jsp:include page="index.jsp"/>
<body>
	<table align="center" width="600" border="1"
 style="border-collapse:collapse;font-size:8pt"
 bordercolor="navy" cellpadding="4" cellspacing="0">
		<tr>
			<td colspan="6">:: 장바구니 내용</td>
		</tr>
		<tr bgcolor="#dedede">
			<th>제품번호</th>
			<th width="25%">제품명</th>
			<th>단가</th>
			<th>수량</th>
			<th>금액</th>
			<th>삭제</th>
		</tr>

        <!-- 장바구니 목록이 있는경우 -->
        <!--  for(CartVo cart : list) -->
        <c:forEach var="cart" items="${ list }">
			<tr align="center">
				<td>${ cart.p_num }</td>
				<td>${ cart.p_name }</td>
				<td>
					단가:<fmt:formatNumber type="currency" value="${ cart.p_price }"/><br>
					<font color="red">
					세일가격:<b><fmt:formatNumber type="currency" value="${ cart.p_saleprice }"/></b>
					</font>
				</td>
				<td>
					<!-- 수량 조정 폼 -->
					<form action="cart_update.do" method="GET">
						<input type="hidden" name="c_idx" value="${ cart.c_idx }">
						<input name="c_cnt" size="4"  align="center" value="${ cart.c_cnt }">
						<input type="submit" value="수정">
					</form>
				</td>
				<td><fmt:formatNumber type="currency" value="${ cart.amount }"/></td>
				<td>
					<input type="button" value="삭제"
						 style="border:1 solid black;cursor:hand"
						 onclick="del('${ cart.c_idx }');">
				</td>
			</tr>
		</c:forEach>

        <!-- 장바구니 비어있는경우  -->
        <c:if test="${ empty list }">
			<tr>
				<td colspan="6" align="center">
					<b>장바구니가 비었습니다.</b>
				</td>
			</tr>
		</c:if>
		

		<tr>
			<td colspan="5" align="right">
				총 결재액 :
			</td>
			<td><fmt:formatNumber type="currency" value="${ total_amount }" /></td>
		</tr>
	</table>
</body>
</html>






