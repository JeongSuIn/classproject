<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
		/* 데이터를 받음 */
	
	// 폼에 입력한 사용자 입력 데이터의 한글 처리
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("userId");
	String pw = request.getParameter("pw");
	String userName = request.getParameter("userName");
	String userPhoto = request.getParameter("userPhoto");
	
	Member member = new Member();
	member.setUserId(userId);
	member.setPassword(pw);
	member.setUserName(userName);
	member.setUserPhoto(userPhoto);
	
	// DAO 객체의 insert 메소드로 member 참조변수 전달
	
%>