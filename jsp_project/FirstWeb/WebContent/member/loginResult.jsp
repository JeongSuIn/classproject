<%@page import="form.FormLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	FormLogin formLogin = new FormLogin();
	
	String userId = request.getParameter("userId");
	String pw = request.getParameter("pw");
	
	formLogin.setId(userId);
	formLogin.setPw(pw);
	
	request.setAttribute("data", formLogin);
	
%>

<jsp:forward page="loginView.jsp"/>