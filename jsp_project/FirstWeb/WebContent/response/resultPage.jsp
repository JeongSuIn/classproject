<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
</head>
<body>
	<%
				String select = request.getParameter("select");
			int selectNum = Integer.parseInt(select);
		
			if (selectNum > 0) {
				out.println(selectNum);
		
				// 현재페이지가 응답 처리가 되고, result.jsp 페이지를 다시 요청
				response.sendRedirect("result.jsp");
			} else {
				out.println(selectNum);
	%>
		<jsp:forward page="result.jsp"></jsp:forward>
	<%
			}
	%>


</body>
</html>