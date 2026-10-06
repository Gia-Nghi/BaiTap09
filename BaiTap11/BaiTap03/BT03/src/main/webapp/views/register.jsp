<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>Đăng ký - Campanula</title>

<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, sans-serif;
	background: #f5f6fa;
	min-height: 100vh;
}

.register-wrapper {
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 40px 20px;
}

.register-box {
	width: 450px;
	max-width: 100%;
	background: white;
	padding: 35px 40px;
	border-radius: 12px;
	box-shadow: 0 8px 25px rgba(0, 0, 0, 0.12);
}

.register-title {
	text-align: center;
	color: #2c3e50;
	margin-bottom: 30px;
	font-size: 28px;
}

.register-input {
	margin-bottom: 18px;
}

.register-input input {
	width: 100%;
	padding: 13px 15px;
	border: 1px solid #ddd;
	border-radius: 6px;
	font-size: 15px;
	outline: none;
	transition: 0.3s;
}

.register-input input:focus {
	border-color: #3498db;
	box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
}

.register-button {
	width: 100%;
	padding: 14px;
	border: none;
	border-radius: 6px;
	background: #3498db;
	color: white;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
	margin-top: 5px;
}

.register-button:hover {
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

.login-text {
	text-align: center;
	margin-top: 25px;
	color: #666;
	font-size: 14px;
}

.login-text a {
	color: #3498db;
	text-decoration: none;
	font-weight: bold;
}

.login-text a:hover {
	text-decoration: underline;
}

/* RESPONSIVE */
@media ( max-width : 500px) {
	.register-box {
		padding: 30px 25px;
	}
	.register-title {
		font-size: 24px;
	}
}
</style>

</head>

<body>

	<div class="register-wrapper">

		<div class="register-box">

			<h2 class="register-title">Tạo tài khoản mới</h2>

			<c:if test="${not empty alert}">
				<div class="alert">${alert}</div>
			</c:if>

			<form action="${pageContext.request.contextPath}/register"
				method="post">

				<!-- TÀI KHOẢN -->

				<div class="register-input">
					<input type="text" name="username" placeholder="Tài khoản"
						value="${param.username}" required>
				</div>

				<!-- HỌ TÊN -->

				<div class="register-input">
					<input type="text" name="fullname" placeholder="Họ tên"
						value="${param.fullname}" required>
				</div>

				<!-- EMAIL -->

				<div class="register-input">
					<input type="email" name="email" placeholder="Nhập Email"
						value="${param.email}" required>
				</div>

				<!-- SỐ ĐIỆN THOẠI -->

				<div class="register-input">
					<input type="text" name="phone" placeholder="Số điện thoại"
						value="${param.phone}" required>
				</div>

				<!-- MẬT KHẨU -->

				<div class="register-input">
					<input type="password" name="password" placeholder="Mật khẩu"
						required>
				</div>

				<!-- NHẬP LẠI MẬT KHẨU -->

				<div class="register-input">
					<input type="password" name="confirmPassword"
						placeholder="Nhập lại mật khẩu" required>
				</div>

				<!-- BUTTON -->

				<button type="submit" class="register-button">Tạo tài khoản
				</button>

			</form>

			<div class="login-text">

				Nếu bạn đã có tài khoản? <a
					href="${pageContext.request.contextPath}/login"> Đăng nhập </a>

			</div>

		</div>

	</div>

</body>

</html>