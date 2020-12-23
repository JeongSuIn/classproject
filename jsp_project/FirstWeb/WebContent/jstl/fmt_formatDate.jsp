<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setAttribute("now", new Date());	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	now1: ${now}
	<fmt:timeZone value="Hongkong">
		<br>
		now2: <fmt:formatDate value="${now}"/>
		<br>
		now3: <fmt:formatDate value="${now}" type="date"/>
		<br>
		now4: <fmt:formatDate value="${now}" type="date" dateStyle="full"/>
		<br>
		now5: <fmt:formatDate value="${now}" type="date" dateStyle="short"/>
		<br>
		now6: <fmt:formatDate value="${now}" type="time" />
		<br>
		now7: <fmt:formatDate value="${now}" type="time" timeStyle="full" />
		<br>
		now8: <fmt:formatDate value="${now}" type="time" timeStyle="short" />
		<br>
		now9: <fmt:formatDate value="${now}" type="both"/>
		<br>
		now10: <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
		<br>
		<br>
		<br>
		패턴1: <fmt:formatDate value="${now}" pattern="z a h:mm"/>
		<br>
		패턴2: <fmt:formatDate value="${now}" pattern="hh:mm"/>
		<br>
		패턴3: <fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm"/>
		<br>
		패턴4: <fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm" timeZone="seoul"/>
</fmt:timeZone>






</body>
</html>