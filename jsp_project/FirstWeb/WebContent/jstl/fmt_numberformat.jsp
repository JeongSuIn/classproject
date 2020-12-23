<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:formatNumber value="1000000" />
	<br>
	<fmt:formatNumber value="1000000" groupingUsed="false" />
	<br>
	<c:set var="number" value="10000000" />
	<fmt:formatNumber value="${number}" />
	<br>
	<fmt:formatNumber var="formatNumber" value="${number}"/> <!-- 변수로 사용 -->
	${formatNumber} <!-- 변수를 출력 -->
	
</body>
</html>