<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="main-login">
		<form action="login"  autocomplete="off" id="form-group" method="post">
			<h2>Thành Viên Đăng nhập</h2>

			<div class="input-group">
				<input type="text" id="username" name="username" required>
				<label for="username">Tài Khoản</label>
			</div>

			<div class="input-group">
				<input type="password" id="password" name="password" required>
				<label for="password">Mật Khẩu</label>
			</div>

			<button type="submit">Đăng nhập</button>
			<p>Bạn chưa có tài khoản ? <a href="register.jsp">Đăng ký</a></p>
		</form>
	</div>
</body>
</html>