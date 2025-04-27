<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<body>
	<a href="../home/main">메인으로 가기</a>
	<a href="list">리스트로 돌아가기</a>
	<h2>게시글 상세보기</h2>
	<%
	int number;
	if (request.getParameter("id") == null) {
		number = 0;
	} else {

		number = Integer.parseInt(request.getParameter("id"));
	}
	%>

	<ul>
		<li>번호 : <%=articleRow.get("id")%>번
		</li>
		<li>등록 날짜 : <%=articleRow.get("regDate")%>번
		</li>
		<li>제목 : <%=articleRow.get("title")%>번
		</li>
		<li>내용 : <%=articleRow.get("body")%>번
		</li>
	</ul>
	<a href="doModify/page?id=<%=articleRow.get("id")%>">수정하기</a>

	<a onClick="if(confirm('정말로 삭제하시겠습니까?') == false){return false;}"
		href="delete?id=<%=articleRow.get("id")%>">삭제하기</a>




</body>
</html>