<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register member</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="main-register">
		<form action="register" method="post" autocomplete="off" id="form-group" class="group-2" name="form-resgter">
			<h2>Đăng ký thành viên</h2>
			
			<div class="input-group">
				<label for="username">Tên đăng nhập</label><br>
				<input type="text" name="username" id="username" required>
			</div>
			
			<div class="input-group">
				<label for="password">Mật khẩu</label><br>
				<input type="password" name="password" id="password" required>
			</div>

			<div class="input-group">
				<label for="name">Họ và tên</label><br>
				<input type="text" name="name" id="name" required>
			</div>

			<div class="input-group">
				<label for="name">Địa chỉ</label><br>
				<input type="text" name="address" id="address" required>
			</div>
			<div class="input-group">
				<label for="address">Email</label><br>
				<input type="email" name="mail" id="mail" required>
			</div>
			
			<button type="submit">Đăng Ký</button>
		</form>
	</div>
</body>
</html>