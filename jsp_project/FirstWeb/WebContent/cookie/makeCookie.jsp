<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 쿠키 객체를 생성
	Cookie c1 = new Cookie("userId", "cool");
	// response.addCooke(쿠키 객체)
	response.addCookie(c1);
	
	Cookie c2 = new Cookie("userName",URLEncoder.encode("김연아", "UTF-8"));
	c2.setMaxAge(60*25);
	response.addCookie(c2);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 생성, 저장</h1>
	<h3>
		<%= c1.getName() %>=<%=c1.getValue() %><br>
		<%= c2.getName() %>=<%=URLDecoder.decode(c2.getValue(), "utf-8" )%><br>
	</h3>
	
	<a href="viewCookie.jsp">쿠키 정보 보기</a>
	
</body>
</html>


