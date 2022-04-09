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
<table border='1'>
	<tr>
		<td colspan='2'>
		<img src= "<%=request.getContextPath()%>/imageSrcView.do?filename=<%=vo.getMem_photo()%>" width="200"> 
		
		</td>
	</tr>
	<tr>
		<td>회원 ID</td>
		<td><%=vo.getMem_id() %></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=vo.getMem_pass()%></td>
	</tr>
	<tr>
		<td>회원이름</td>
		<td><%=vo.getMem_name() %></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><%=vo.getMem_tel() %></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><%=vo.getMem_addr() %></td>
	</tr>
	<tr>
		<td colspan='2'>
		<input type="button" value="수정" onClick="location.href='<%=request.getContextPath() %>/modifymember.do?id=<%=vo.getMem_id()%>'"> 
		<input type="button" value="삭제" onClick="location.href='<%=request.getContextPath() %>/deletemember.do?id=<%=vo.getMem_id()%>'"> 
		<input type="button" value="회원목록" onClick="location.href='<%=request.getContextPath() %>/member/start.jsp'"> 
		</td>
	</tr>
</table>


</body>
</html>