<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String email = (String) session.getAttribute("email");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirm</title>
</head>
<body>
	<h1>confirm</h1>
	<form action="/test-4/confirm" method="post">
	<div>
		<label for="email">メールアドレス:</label><%= email %>
	</div>
	<div>
		<label for="password">パスワード:</label><input type="password" id="password"
			name="password" required>
	</div>
	<div>
		<button type="submit">登録</button>
	</div>
	</form>
</body>
</html>