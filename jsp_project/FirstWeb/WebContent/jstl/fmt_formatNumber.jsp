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
	<fmt:formatNumber var="formatNumber" value="${number}"/> <!-- 변수로 저장 -->
	${formatNumber} <!-- 변수를 출력 -->
	<br>
	
	통화: <fmt:formatNumber value="${number}" type="currency" currencySymbol="$"/> 
	<br>
	퍼센트: <fmt:formatNumber value="${number/5}" type="percent" groupingUsed="false"/>
	<br>
	패턴: <fmt:formatNumber value="${number}" pattern="0,000,000 ,000.00"/>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>