<%@page import="util.CookieBox"%>
<%@page import="form.FormLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	FormLogin formLogin = new FormLogin();
	
	String userId = request.getParameter("userId");
	String pw = request.getParameter("pw");
	
	String chk = request.getParameter("chk");
	
	if(chk!=null && chk.equals("on") && userId!=null &&userId.isEmpty()){
		// 쿠키 생성 저장
		// uid=userId
		
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 60*60*24*365));
	} else{
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 0));
	}
	
	formLogin.setId(userId);
	formLogin.setPw(pw);
	
	request.setAttribute("data", formLogin);
	
%>

<jsp:forward page="loginView.jsp"/>