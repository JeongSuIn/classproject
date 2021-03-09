<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
s<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>

	

	


	<h3>게시판 리스트</h3>
	<div>
		<table>
			<tr>
				<th>no.</th>
				<th>User Name</th>
				<th>Title</th>
				<th>Contents</th>
				<th>Image</th>
			</tr>
			<%-- <c:forEach items="${list}" var="board"> --%>
			<tr>
				<td>${board.idx}</td>
				<td>${board.user_name}</td>
				<td>${board.title}</td>
				<td>${board.contents}</td>
				<td><img alt="업로드 사진"
								src="<c:url value="/fileupload/s_${board.image}"/>"></td>
				
			</tr>
			<%-- </c:forEach> --%>
		</table>
	</div>
</body>
</html>