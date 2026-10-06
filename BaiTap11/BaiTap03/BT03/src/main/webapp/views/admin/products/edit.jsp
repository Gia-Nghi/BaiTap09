<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Sửa sản phẩm</title>

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
}

.container {
	width: 600px;
	margin: 50px auto;
	background: white;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #2c3e50;
}

label {
	display: block;
	margin-top: 15px;
	margin-bottom: 8px;
	font-weight: bold;
}

input, textarea, select {
	width: 100%;
	padding: 12px;
	border: 1px solid #ddd;
	border-radius: 6px;
}

textarea {
	height: 100px;
}

.button-group {
	display: flex;
	gap: 15px;
	margin-top: 25px;
}

button, a {
	flex: 1;
	padding: 12px;
	border: none;
	border-radius: 6px;
	text-align: center;
	text-decoration: none;
	cursor: pointer;
}

button {
	background: #3498db;
	color: white;
}

.back {
	background: #95a5a6;
	color: white;
}
</style>

</head>

<body>

	<div class="header">Campanula - Sửa sản phẩm</div>

	<div class="container">

		<h1>SỬA SẢN PHẨM</h1>

		<form action="${pageContext.request.contextPath}/edit-product"
			method="post">

			<input type="hidden" name="id" value="${product.id}"> <label>Tên
				sản phẩm</label> <input type="text" name="productname"
				value="${product.productname}" required> <label>Mô
				tả</label>

			<textarea name="description">${product.description}</textarea>

			<label>Giá sản phẩm</label> <input type="number" name="price"
				value="${product.price}" required> <label>Link hình
				ảnh</label> <input type="text" name="images" value="${product.images}">

			<label>Danh mục</label> <select name="cateID">

				<option value="1" ${product.cateID == 1 ? 'selected' : ''}>
					Nước hoa nữ</option>

				<option value="2" ${product.cateID == 2 ? 'selected' : ''}>
					Nước hoa nam</option>

				<option value="3" ${product.cateID == 3 ? 'selected' : ''}>
					Nước hoa unisex</option>

			</select>

			<div class="button-group">

				<button type="submit">Cập nhật sản phẩm</button>

				<a class="back"
					href="${pageContext.request.contextPath}/manage-product"> Quay
					lại </a>

			</div>

		</form>

	</div>

</body>
</html>