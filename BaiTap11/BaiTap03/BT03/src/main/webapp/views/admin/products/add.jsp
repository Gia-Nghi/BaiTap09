<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Thêm sản phẩm</title>

<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, sans-serif;
	background: #f5f6fa;
}

.header {
	background: #2c3e50;
	color: white;
	padding: 20px 60px;
	font-size: 24px;
	font-weight: bold;
}

.container {
	width: 600px;
	max-width: 90%;
	margin: 50px auto;
}

.form-box {
	background: white;
	padding: 35px;
	border-radius: 12px;
	box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #2c3e50;
	margin-bottom: 30px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 8px;
}

input, textarea, select {
	width: 100%;
	padding: 12px;
	margin-bottom: 20px;
	border: 1px solid #ddd;
	border-radius: 6px;
	font-size: 15px;
}

textarea {
	height: 100px;
	resize: vertical;
}

.button-group {
	display: flex;
	gap: 15px;
}

button, .back-button {
	flex: 1;
	padding: 13px;
	border: none;
	border-radius: 6px;
	text-align: center;
	text-decoration: none;
	font-size: 16px;
	cursor: pointer;
}

button {
	background: #27ae60;
	color: white;
}

.back-button {
	background: #95a5a6;
	color: white;
}
</style>

</head>

<body>

	<div class="header">Campanula - Quản lý sản phẩm</div>

	<div class="container">

		<div class="form-box">

			<h1>THÊM SẢN PHẨM</h1>

			<form action="${pageContext.request.contextPath}/add-product"
				method="post">

				<label>Tên sản phẩm</label> <input type="text" name="productname"
					required> <label>Mô tả</label>

				<textarea name="description" required></textarea>


				<label>Giá sản phẩm</label> <input type="number" name="price"
					min="0" required> <label>Link hình ảnh</label> <input
					type="text" name="images"> <label>Danh mục</label> <select
					name="cateID">

					<option value="1">Nước hoa nữ</option>

					<option value="2">Nước hoa nam</option>

					<option value="3">Nước hoa unisex</option>

				</select>


				<div class="button-group">

					<button type="submit">Thêm sản phẩm</button>

					<a href="${pageContext.request.contextPath}/manage-product"
						class="back-button"> Quay lại </a>

				</div>

			</form>

		</div>

	</div>

</body>

</html>