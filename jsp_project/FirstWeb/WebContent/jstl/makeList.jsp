<%@page import="member.Member"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Member> members = new ArrayList<Member>();
	members.add(new Member("cool1", "1111", "COOL11", "photo11.jpg"));
	members.add(new Member("cool2", "2222", "COOL12", "photo22.jpg"));
	members.add(new Member("cool3", "3333", "COOL13", null));
	members.add(new Member("cool4", "4444", "COOL14", "photo44.jpg"));
	members.add(new Member("cool5", "5555", "COOL15", "photo55.jpg"));
	members.add(new Member("cool6", "6666", "COOL16", "photo66.jpg"));
	members.add(new Member("cool7", "7777", "COOL17", "photo77.jpg"));
	members.add(new Member("cool8", "8888", "COOL18", null));
	members.add(new Member("cool9", "9999", "COOL19", null));
	members.add(new Member("cool10", "0000", "COOL01", "photo1.jpg"));
	
	session.setAttribute("members", members);
	
%>