<%@page import="form.FormLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	FormLogin data = (FormLogin)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 데이터 출력</title>
</head>
<body>
	<h1>로그인 데이터 출력</h1>
		<table>
			<tr>
				<td>아이디</td>
				<td><%= data.getId() %></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><%= data.getPw() %></td>
			</tr>
			
		</table>
</body>
</html>