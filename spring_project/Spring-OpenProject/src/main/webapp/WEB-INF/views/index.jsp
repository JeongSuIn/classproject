<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%-- <link rel="stylesheet" href="<c:url value="/css/default.css"/>"> --%>

<%@ include file="/WEB-INF/views/include/basicset.jsp" %>
	
	
	

</head>
<body>

	

	<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<%@ include file="/WEB-INF/views/include/nav.jsp" %>

	<div class="contents">
		<h2 class="content_title">index</h2>
		<hr>
		<div class="content">
			인덱스 페이지 입니다.
		</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp" %>

</body>
</html>