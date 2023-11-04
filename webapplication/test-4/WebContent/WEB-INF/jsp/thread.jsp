<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="entity.Message"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.User"%>

<%
List<Message> messages = (List<Message>) request.getAttribute("messages");
Integer threadId = (Integer) request.getAttribute("threadId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thread</title>
</head>
<body>
	<h1>スレッド</h1>
	<ul>
		<%
		for (Message message : messages) {
		%>
		<li><%=message.getContent()%> : <%=message.getOwnerId()%> : <%=message.getTimestamp()%>
			<%
			}
			%>
	</ul>
	<!-- 新しいメッセージを投稿するフォーム -->
	<form action="/test-4/thread/<%= threadId %>" method="post">
		<label for="content">メッセージ内容:</label><input type="text" id="content"
			name="content" required>
		<button type="submit">投稿</button>
	</form>
	<p><a href="/test-4/thread">back</a></p>
</body>
</html>