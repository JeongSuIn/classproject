<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setAttribute("userName", "김연아1");
	session.setAttribute("userName", "김연아2");
	application.setAttribute("userName", "김연아3");
	session.setAttribute("userId", "Kim");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		requestScope.userName: ${requestScope.userName}
													, ${userName}
													, <%= request.getAttribute("userName") %><br>
			
		sessionScope.userId: ${sessionScope.userId}
												, ${userId}
												, <%= session.getAttribute("userId") %> <br>
			
		param.code:  ${param.code},
			<%= request.getParameter("code") %><br>
			
		pageContext: ${pageContext.request.requestURI}<br>
								, ${pageContext.request.requestURL}<br>
								, ${pageContext.request.contextPath}<br>
								,	<%= pageContext.getRequest().getServletContext().getContextPath() %><br>
	</h1>
	
	<a href="view1.jsp">session 페이지 확인</a>
	
	
	
	
	
	
	
	
	
	
</body>
</html>