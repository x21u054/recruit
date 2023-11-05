<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entity.Thread"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.User"%>

<%
List<Thread> threads = (List<Thread>) request.getAttribute("threads");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thread view</title>
</head>
<body>
	<h1>スレッド一覧</h1>
	<ul>
		<%
		String baseUrl = "/test-4/thread/";
		for (Thread thread : threads) {
			String url = baseUrl + thread.getId();
		%>
		<li><a href=<%=url%>> <%=thread.getTitle()%>
		</a> <%
 }
 %>
	</ul>
	<form action="/test-4/thread" method="post">
		<label for="title">タイトル:</label><input type="text" id="title"
			name="title" required>
		<button type="submit">作成</button>
	</form>
	<p><a href="/test-4/home">戻る</a></p>
</body>
</html>