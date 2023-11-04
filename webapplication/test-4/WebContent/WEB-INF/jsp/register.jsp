<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
	<h1>login</h1>
	<form action="/test-4/register" method="post">
	<div>
		<label for="email">メールアドレス:</label><input type="text" id="email"
			name="email" required>
	</div>
	<div>
		<label for="password">パスワード:</label><input type="password" id="password"
			name="password" required>
	</div>
	<div>
		<button type="submit">登録</button>
	</div>
	</form>
	<p>
		<a href="/test-4/login">login</a>
	</p>
	<p>
		<a href="/test-4/">back</a>
	</p>
</body>
</html>