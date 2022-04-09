<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>


<table border ='1'>
	<tr>
		<td colspan='5'>
		<input type ='button' value="회원추가" id='addmember' onClick="location.href ='member/insertmember.jsp'"> 
		</td>
	</tr>
	<tr>
		<td>ID</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>전화번호</td>
		<td>주소</td>
	</tr>
	<%
 List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
%>
	<%
		for(MemberVO vo : list){
	%>
	<tr>
		<td><a href='<%=request.getContextPath() %>/memberdetail.do?id=<%=vo.getMem_id()%>'><%=vo.getMem_id()%></a></td>
		<td><%=vo.getMem_pass() %></td>
		<td><%=vo.getMem_name() %></td>
		<td><%=vo.getMem_tel() %></td>
		<td><%=vo.getMem_addr() %></td>
	</tr>	
	
	<%
		}
	%>
</table>



</body>
</html>