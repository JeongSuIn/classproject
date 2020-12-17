<%@page import="util.CookieBox"%>
<%@page import="form.FormLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	
	// 데이터 받기: 아이디, 비밀번호
	String userId = request.getParameter("userid");
	String pw = request.getParameter("pw");
	
	String chk = request.getParameter("chk");
	
	if(chk!=null && chk.equals("on") && userId!=null && !userId.isEmpty()){
		// 쿠키 생성 저장
		// uid=userId
		
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 60*60*24*365));
	} else{
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 1));
	}
	
	// beans 생성
	FormLogin formLogin = new FormLogin();
	
	//데이터 바인딩
	formLogin.setId(userId);
	formLogin.setPw(pw);
	
	request.setAttribute("data", formLogin);
	
%>

<!-- login_view.jsp로 포워딩 -->
<jsp:forward page="loginView.jsp"/>