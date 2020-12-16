<%@page import="form.FormReg"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  // beans 객체를 생성 
	FormReg formReg = new FormReg();
	
	// 사용자로부터 데이터를 받아옴.
	String userId = request.getParameter("userId");
	String pw = request.getParameter("pw");
	String userName = request.getParameter("userName");
	String userPhoto = request.getParameter("userPhoto");
	
	// beans에 데이터를 저장
	formReg.setId(userId);
	formReg.setPw(pw);
	formReg.setName(userName);
	formReg.setPhoto(userPhoto);
	
	// regView.js로 beans 객체를 전달
	request.setAttribute("data", formReg);
%>

<jsp:forward page="regView.jsp"/>