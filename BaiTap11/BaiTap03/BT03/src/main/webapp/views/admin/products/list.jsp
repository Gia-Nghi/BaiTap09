<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Quản lý sản phẩm</title>

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
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.logo {
	font-size: 24px;
	font-weight: bold;
}

.menu a {
	color: white;
	text-decoration: none;
	margin-left: 25px;
}


.container {
	width: 90%;
	margin: 40px auto;
}


.top {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 25px;
}

.top h1 {
	color: #2c3e50;
}


.add-button {
	background: #27ae60;
	color: white;
	padding: 12px 20px;
	text-decoration: none;
	border-radius: 6px;
}


table {
	width: 100%;
	border-collapse: collapse;
	background: white;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.08);
}

th {
	background: #2c3e50;
	color: white;
	padding: 15px;
}

td {
	padding: 12px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

.product-img {
	width: 70px;
	height: 70px;
	object-fit: cover;
	border-radius: 5px;
}

/* BUTTONS */
.edit-button {
	background: #f39c12;
	color: white;
	padding: 8px 12px;
	text-decoration: none;
	border-radius: 5px;
}

.delete-button {
	background: #e74c3c;
	color: white;
	padding: 8px 12px;
	text-decoration: none;
	border-radius: 5px;
	margin-left: 5px;
}

.empty {
	text-align: center;
	color: #777;
	font-size: 18px;
}
</style>
</head>

<body>

	<div class="header">

		<div class="logo">Campanula - Quản lý sản phẩm</div>

		<div class="menu">

			<a href="${pageContext.request.contextPath}/product"> Xem cửa
				hàng </a> <a href="${pageContext.request.contextPath}/logout"> Đăng
				xuất </a>

		</div>

	</div>


	<div class="container">

		<div class="top">

			<h1>QUẢN LÝ SẢN PHẨM</h1>

			<a href="${pageContext.request.contextPath}/add-product"
				class="add-button"> + Thêm sản phẩm </a>

		</div>


		<c:if test="${empty productList}">

			<div class="empty">Chưa có sản phẩm nào!</div>

		</c:if>


		<c:if test="${not empty productList}">

			<table>

				<tr>
					<th>ID</th>
					<th>Hình ảnh</th>
					<th>Tên sản phẩm</th>
					<th>Mô tả</th>
					<th>Giá</th>
					<th>Danh mục</th>
					<th>Thao tác</th>
				</tr>


				<c:forEach items="${productList}" var="product">

					<tr>

						<td>${product.id}</td>

						<td><img src="${product.images}" class="product-img"
							onerror="this.onerror=null;
                                this.src='https://placehold.co/70x70?text=No+Image';">

						</td>

						<td>${product.productname}</td>

						<td>${product.description}</td>

						<td><fmt:formatNumber value="${product.price}" type="number"
								groupingUsed="true" maxFractionDigits="0" /> VNĐ</td>

						<td>${product.cateID}</td>

						<td><a
							href="${pageContext.request.contextPath}/edit-product?id=${product.id}"
							class="edit-button"> Sửa </a> <a
							href="${pageContext.request.contextPath}/delete-product?id=${product.id}"
							class="delete-button"
							onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?')">

								Xóa </a></td>

					</tr>

				</c:forEach>

			</table>

		</c:if>

	</div>
	

</body>
</html>