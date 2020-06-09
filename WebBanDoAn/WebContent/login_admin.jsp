<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="main-login">
		<form action="system"  autocomplete="off" id="form-group" method="post">
			<h2>Đăng nhập hệ thống</h2>

			<div class="input-group">
				<input type="text" id="username" name="username" required>
				<label for="username">Tài Khoản</label>
			</div>

			<div class="input-group">
				<input type="password" id="password" name="password" required>
				<label for="password">Mật Khẩu</label>
			</div>

			<button type="submit">Đăng nhập hệ thống</button>
		</form>
	</div>
</body>
</html>