<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Xác nhận OTP - Campanula</title>

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

.otp-wrapper {
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 20px;
}

.otp-box {
	width: 420px;
	max-width: 100%;
	background: white;
	padding: 40px;
	border-radius: 12px;
	box-shadow: 0 8px 25px rgba(0, 0, 0, 0.12);
}

.otp-box h2 {
	text-align: center;
	color: #2c3e50;
	margin-top: 0;
	margin-bottom: 10px;
	font-size: 28px;
}

.otp-description {
	text-align: center;
	color: #777;
	font-size: 14px;
	margin-bottom: 25px;
}

.alert {
	background: #fdecea;
	color: #e74c3c;
	padding: 12px;
	border-radius: 6px;
	text-align: center;
	margin-bottom: 20px;
}

.otp-input {
	margin-bottom: 20px;
}

.otp-input input {
	width: 100%;
	padding: 14px;
	border: 1px solid #ddd;
	border-radius: 6px;
	font-size: 18px;
	text-align: center;
	letter-spacing: 5px;
	outline: none;
	transition: 0.3s;
}

.otp-input input:focus {
	border-color: #3498db;
	box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
}

.otp-button {
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

.otp-button:hover {
	background: #2980b9;
}

@media ( max-width : 500px) {
	.otp-box {
		padding: 30px 25px;
	}
	.otp-box h2 {
		font-size: 24px;
	}
}
</style>

</head>

<body>

	<div class="otp-wrapper">

		<div class="otp-box">

			<h2>Xác nhận tài khoản</h2>

			<p class="otp-description">Vui lòng nhập mã OTP gồm 6 số để xác
				nhận tài khoản.</p>

			<c:if test="${not empty alert}">
				<div class="alert">${alert}</div>
			</c:if>

			<form action="${pageContext.request.contextPath}/verify-otp"
				method="post">

				<div class="otp-input">

					<input type="text" name="otp" placeholder="Nhập mã OTP gồm 6 số"
						maxlength="6" required>

				</div>

				<button type="submit" class="otp-button">Xác nhận OTP</button>

			</form>

		</div>

	</div>

</body>

</html>