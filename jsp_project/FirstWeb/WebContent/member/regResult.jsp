<%@page import="util.CookieBox"%>
<%@page import="form.FormReg"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    
<%
	// 데이터 받기: 아이디, 비밀번호
	String userId = request.getParameter("userId");
	String pw = request.getParameter("pw");
	String userName = request.getParameter("userName");
	String userPhoto = request.getParameter("userPhoto");
	String chk = request.getParameter("chk");

	if(chk!=null && chk.equals("on") && userId!=null && !userId.isEmpty()){
		// 쿠키 생성 저장
		// uid=userId
		
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 60*60*24*365));
	} else{
		response.addCookie(CookieBox.createCookie("uid", userId, "/", 1));
	}

  // beans 객체를 생성 
	FormReg formReg = new FormReg();
	
	
	
	// beans에 데이터를 저장
	formReg.setId(userId);
	formReg.setPw(pw);
	formReg.setName(userName);
	formReg.setPhoto(userPhoto);
	
	// regView.js로 beans 객체를 전달
	request.setAttribute("data", formReg);
%>

<jsp:forward page="regView.jsp"/>