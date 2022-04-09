<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#idcheck').on('click', function(){
			id = $('#id').val();
			
			$.ajax({
				url : '/memberWeb/idcheck.do',
				type : 'post',
				data :{'id':id},
				success : function(res){
					
					if(res>0){
						alert('이미존재하는 아이디 입니다.');
					}else{
						alert('사용가능한 아이디입니다.');
					}
					
				},
				error: function(xhr){
					alert(xhr.status);
				},
				dataType: 'json'				
			})
			
		})	
	})
	

</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/insertMember.do" method = "post" enctype="multipart/form-data">
<table border='1'>
	<tr>
		<td>회원ID</td>
		<td><input type="text" name="id" id='id'><input type="button" value="중복확인" id="idcheck"> </td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" name="pass"></td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td><input type="text" name="pass2"></td>
	</tr>
	<tr>
		<td>회원이름</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="tel"></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><input type="text" name="addr"></td>
	</tr>
	<tr>
		<td>프로필 사진</td>
		<td><input type="file" name="file"></td>
	</tr>
	<tr>
		<td colspan ='2'>
		<input type='submit' value ="저장" id='save'>
		<input type='reset' value ="취소">
		<input type='button' value ="회원목록" id='save' onclick = "location.href='start.jsp'">
		</td>		
	</tr>
</form>
</table>
</body>
</html>