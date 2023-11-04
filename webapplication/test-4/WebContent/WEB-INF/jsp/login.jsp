<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h1>login</h1>
	<form action="/test-4/login" method="post">
		<div>
			<label for="email">メールアドレス:</label><input type="text" id="email"
				name="email" required>
		</div>
		<div>
			<label for="password">パスワード:</label><input type="password"
				id="password" name="password" required>
		</div>
		<div>
			<button type="submit">ログイン</button>
		</div>
	</form>
	<p>
		<a href="/test-4/register">register</a>
	</p>
	<p>
		<a href="/test-4/">back</a>
	</p>
</body>
</html>