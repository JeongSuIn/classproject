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
		<h2>게시글 작성하기</h2>
		<hr>
		<div class="content">
			<form>
				<table>
					<tr>
						<th><label for="userName">작성자</label></th>
						<td><input type="text" id="userName" name="userName"></td>
					</tr>
					<tr>
						<th><label for="userTitle">제목</label></th>
						<td><input type="text" id="userTitle" name="userTitle"></td>
					</tr>
					<tr>
						<th><label for="userContents">내용</label></th>
						<td><input type="text" id="userContents" name="userContents"></td>
					</tr>
					<tr>
						<th><label for="userImage">제목</label></th>
						<td><input type="file" id="userImage" name="userImage"></td>
					</tr>
					
				</table>
			</form>
			
			<div>
			<input type="button" value="작성 완료" id="btnWrite">
			</div>
			
		</div> <!-- .content --> 
	</div> <!-- .contents -->
	
	<script>
		$(document).ready(function(){
			$('#btnWrite').click(function(){
				var photoFile = $('#userImage');
				
				var file1 =  photoFile[0].files[0];
			()	
				console.log(file1);
				
				var formData = new FormData();
				formData.append("userName", $('#userName').val());
				formData.append("userTitle", $('#userTitle').val());
				formData.append("userContents", $('#userContents').val());
				formData.append("userImage", file1);
				
				console.log(formData);
				

				$.ajax({
					url : '/op/member/reg',
					type : 'post',
					data : formData,
					enctype : 'multipart/form-data',
					processData : false,
					contentType : false,
					cache : false ,
					success : function(data){
						console.log(data);
					}
				});
			});
		}); //ready
	
	
	</script>
</body>
</html>