<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>email-verify</title>
</head>
<body>
	<h1>email-verify</h1>
	<form action="/test-4/email-verify" method="post">
	<div>
		<label for="email">メールアドレス:</label><input type="text" id="email"
			name="email" required>
	</div>
	<div>
		<button type="submit">送信</button>
	</div>
	</form>
	<p>
		<a href="/test-4/">トップページへ戻る</a>
	</p>
</body>
</html>