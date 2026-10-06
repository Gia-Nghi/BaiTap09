<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Quên mật khẩu</title>
</head>

<body>

	<h2>Quên mật khẩu</h2>

	<p style="color: red">${alert}</p>

	<form action="${pageContext.request.contextPath}/forgot-password"
		method="post">

		<input type="email" name="email" placeholder="Nhập Email" required>

		<br>
		<br>

		<button type="submit">Gửi mã OTP</button>

	</form>

</body>

</html>