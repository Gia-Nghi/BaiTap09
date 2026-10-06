<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Đặt lại mật khẩu - Campanula</title>

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

.reset-wrapper {
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 20px;
}

.reset-box {
	width: 420px;
	max-width: 100%;
	background: white;
	padding: 40px;
	border-radius: 12px;
	box-shadow: 0 8px 25px rgba(0, 0, 0, 0.12);
}

.reset-title {
	text-align: center;
	color: #2c3e50;
	margin-bottom: 30px;
	font-size: 28px;
}

.reset-input {
	margin-bottom: 18px;
}

.reset-input input {
	width: 100%;
	padding: 13px 15px;
	border: 1px solid #ddd;
	border-radius: 6px;
	font-size: 15px;
	outline: none;
	transition: 0.3s;
}

.reset-input input:focus {
	border-color: #3498db;
	box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
}

/* BUTTON */
.reset-button {
	width: 100%;
	padding: 14px;
	border: none;
	border-radius: 6px;
	background: #3498db;
	color: white;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
}

.reset-button:hover {
	background: #2980b9;
}

.alert {
	background: #fdecea;
	color: #e74c3c;
	padding: 12px;
	border-radius: 6px;
	text-align: center;
	margin-bottom: 20px;
}

@media ( max-width : 500px) {
	.reset-box {
		padding: 30px 25px;
	}
	.reset-title {
		font-size: 24px;
	}
}
</style>

</head>

<body>

	<div class="reset-wrapper">

		<div class="reset-box">

			<h2 class="reset-title">Đặt lại mật khẩu</h2>

			<p class="alert">${alert}</p>

			<form action="${pageContext.request.contextPath}/reset-password"
				method="post">

				<div class="reset-input">

					<input type="password" name="password"
						placeholder="Nhập mật khẩu mới" required>

				</div>

				<div class="reset-input">

					<input type="password" name="confirmPassword"
						placeholder="Nhập lại mật khẩu" required>

				</div>

				<button type="submit" class="reset-button">Đổi mật khẩu</button>

			</form>

		</div>

	</div>

</body>

</html>