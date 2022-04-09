<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% MemberVO vo = (MemberVO)request.getAttribute("memdetail"); %>
</head>
<body>
<form action="<%=request.getContextPath()%>/updatemember2.do?id=<%=vo.getMem_id()%>" method = "post" enctype="multipart/form-data">
<table border='1'>
	<tr>
		<td colspan ='2'></td>
	</tr>
	<tr>
		<td>회원ID</td>
		<td><%=vo.getMem_id()%></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type='text' name='pass'></td>
	</tr>
	<tr>
		<td>회원이름</td>
		<td><input type='text' name='name'></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type='text' name='tel'></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><input type='text' name='addr'></td>
	</tr>
	<tr>
		<td>프로필 사진</td>
		<td><input type='file' name='file'></td>
	</tr>
	<tr>
		<td colspan='2'>
		<input type='submit' value ="저장" id='save'>
		<input type='reset' value ="취소">
		<input type='button' value ="회원목록" id='save' onclick = "location.href='<%=request.getContextPath() %>/member/start.jsp'">
		
		</td>
	</tr>

</table>

</form>
</body>
</html>