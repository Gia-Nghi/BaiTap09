<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Đăng nhập - Campanula</title>

<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, sans-serif;
	background: #f5f6fa;
}

.login-wrapper {
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.login-box {
	width: 420px;
	background: white;
	padding: 40px;
	border-radius: 12px;
	box-shadow: 0 8px 25px rgba(0, 0, 0, 0.12);
}

.login-title {
	text-align: center;
	color: #2c3e50;
	margin-bottom: 30px;
	font-size: 26px;
}

.login-input {
	margin-bottom: 18px;
}

.login-input input {
	width: 100%;
	padding: 14px 15px;
	border: 1px solid #ddd;
	border-radius: 6px;
	font-size: 15px;
	outline: none;
	transition: 0.3s;
}

.login-input input:focus {
	border-color: #3498db;
	box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
}

/* NHỚ TÔI + QUÊN MẬT KHẨU */
.login-options {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 25px;
	font-size: 14px;
}

.remember {
	display: flex;
	align-items: center;
	gap: 6px;
	color: #555;
}

.forgot-password {
	color: #3498db;
	text-decoration: none;
}

.forgot-password:hover {
	text-decoration: underline;
}

.login-button {
	width: 100%;
	padding: 14px;
	border: none;
	background: #3498db;
	color: white;
	font-size: 16px;
	border-radius: 6px;
	cursor: pointer;
	transition: 0.3s;
}

.login-button:hover {
	background: #2980b9;
}

.alert {
	background: #fdecea;
	color: #e74c3c;
	padding: 12px;
	border-radius: 6px;
	margin-bottom: 20px;
	text-align: center;
}

.register-text {
	text-align: center;
	margin-top: -80px;
	position: relative;
	color: #666;
	font-size: 15px;
}

.register-text a {
	color: #3498db;
	text-decoration: none;
	font-weight: bold;
}

.register-text a:hover {
	text-decoration: underline;
}

@media screen and (max-width: 500px) {
	.login-box {
		width: 90%;
		padding: 30px 25px;
	}
	.login-options {
		flex-direction: column;
		align-items: flex-start;
		gap: 10px;
	}
}
</style>

</head>

<body>

	<div class="login-wrapper">

		<div class="login-box">

			<h2 class="login-title">Đăng Nhập Vào Hệ Thống</h2>

			<c:if test="${not empty alert}">
				<div class="alert">${alert}</div>
			</c:if>

			<form action="${pageContext.request.contextPath}/login" method="post">

				<!-- Tài khoản -->
				<div class="login-input">
					<input type="text" name="username" placeholder="Tài khoản" required>
				</div>

				<!-- Mật khẩu -->
				<div class="login-input">
					<input type="password" name="password" placeholder="Mật khẩu"
						required>
				</div>

				<!-- Nhớ tôi + Quên mật khẩu -->
				<div class="login-options">

					<label class="remember"> <input type="checkbox"
						name="remember"> <span>Nhớ tôi</span>
					</label> <a href="${pageContext.request.contextPath}/forgot-password"
						class="forgot-password"> Quên mật khẩu? </a>

				</div>

				<!-- Đăng nhập -->
				<button type="submit" class="login-button">Đăng nhập</button>

			</form>

		</div>

	</div>

	<div class="register-text">

		Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a
			href="${pageContext.request.contextPath}/register"> Đăng ký </a>

	</div>

</body>
</html>