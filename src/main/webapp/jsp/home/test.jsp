<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트</title>
</head>
<body>
	<h1>
		<%=id%>번 게시글
	</h1>

	<%
	for (int i = 0; i < 10; i++) {
	%>
	<div>
		숫자 =
		<%=i%>
	</div>

	<%
	}
	%>

</body>
</html>