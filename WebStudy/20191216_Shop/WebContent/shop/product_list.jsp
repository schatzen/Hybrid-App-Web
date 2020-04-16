<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

   function modify(idx,category){
	   
	   //수정폼 띄우기 :  ProductModifyFormAction
	   location.href="modify_form.do?idx=" + idx;
   } 
   
   function del(idx,category){
	   
	   if(confirm("정말 삭제 하시겠습니까?")==false)return;
	   
	   //            ProductDeleteAction
	   //            주의) DB + 업로드된 화일도 삭제
	   location.href="delete.do?idx=" + idx + "&category=" + category;
	   
   }



</script>


</head>
<body>

<jsp:include page="index.jsp"/>

<table align="center" width="600" border="1"
 style="border-collapse:collapse;font-size:8pt"
 bordercolor="navy" cellpadding="4" cellspacing="0">
	<tr bgcolor="#dedede">
		<th width="10%">제품번호</th>
		<th width="10%">이미지</th>
		<th width="35%">제품명</th>
		<th width="20%">제품가격</th>
		<th width="25%">비고</th>
	</tr>

    <!-- 상품이 없는경우 -->
    <c:if test="${ empty list }">
       <tr>
          <td colspan="5" align="center">
             <span>등록된 상품이 없습니다</span>
          </td>
       </tr>
    </c:if>
    
    <!-- 등록상품이 있는경우  -->
    <!--  for(ProductVo product : list )  -->
    <c:forEach var="product"  items="${ list }">
		<tr align="center">
			<td>${ product.p_num }</td>
			<td><img src="../images/${ product.p_image_s }" 
				width="100" height="90"></td>
			<td>
			  <a href="view.do?idx=${ product.idx }">${ product.p_name }</a>
			</td>
			<td>
				할인가:<fmt:formatNumber value="${ product.p_saleprice }"/>원<br>
				<font color="red">
					(${ product.discount_rate }%)
				</font>
			</td>
			<td>
				단가:<fmt:formatNumber value="${ product.p_price }"/>원<br>
				
				<c:if test="${ (not empty user) and (user.grade eq '관리자') }">
				   
				   <input type="button"  value="수정" onclick="modify('${ product.idx }');">
				   <input type="button"  value="삭제" onclick="del('${ product.idx }','${ product.category }');" >
				
				</c:if>
				
			</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>









