<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// 모든 Java API를 사용할 수 있다.
    	
    	Connection conn = null;
    
    	// 1.드라이버 로드
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	// 2. 데이버베이스 연결: Connection 객체를 얻어온다.
    	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
    	String user = "bit";
    	String password = "bit";
    	
    	conn = DriverManager.getConnection(jdbcUrl, user, password);
    	
    	out.println("<h1>mysql 연결</h1>")
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mysql Connection</title>
</head>
<body>

</body>
</html>