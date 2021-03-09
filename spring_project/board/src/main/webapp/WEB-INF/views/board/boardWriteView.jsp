<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="contents">
		<h2 class="content_title">작성 완료</h2>
		<hr>
		<div class="content">
		
				<c:if test="${result>0}">
					글 등록 완료.
				</c:if>
				<c:if test="${result eq 0}">
					글 등록 실패
				</c:if>
			
		</div>
	</div>
</body>
</html>