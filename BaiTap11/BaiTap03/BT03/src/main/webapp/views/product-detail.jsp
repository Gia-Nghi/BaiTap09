<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>${product.productname}- Campanula</title>

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

.menu a:hover {
	color: #3498db;
}

.container {
	width: 85%;
	max-width: 1200px;
	margin: 50px auto;
}

.product-detail {
	background: white;
	border-radius: 15px;
	overflow: hidden;
	display: flex;
	min-height: 500px;
	box-shadow: 0 5px 20px rgba(0, 0, 0, 0.12);
}

.product-image-box {
	width: 50%;
	background: #eeeeee;
	display: flex;
	justify-content: center;
	align-items: center;
}

.product-image-box img {
	width: 100%;
	height: 500px;
	object-fit: cover;
}

.product-info {
	width: 50%;
	padding: 50px;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.product-name {
	font-size: 36px;
	color: #2c3e50;
	margin-bottom: 20px;
}

.line {
	width: 80px;
	height: 4px;
	background: #3498db;
	margin-bottom: 25px;
}

.product-description {
	font-size: 17px;
	color: #777;
	line-height: 1.7;
	margin-bottom: 25px;
}

.product-price {
	font-size: 30px;
	font-weight: bold;
	color: #e74c3c;
	margin-bottom: 30px;
}

.back-button {
	display: inline-block;
	width: fit-content;
	background: #3498db;
	color: white;
	padding: 14px 30px;
	border-radius: 8px;
	text-decoration: none;
	transition: 0.3s;
}

.back-button:hover {
	background: #2980b9;
}

@media ( max-width : 768px) {
	.header {
		padding: 20px;
	}
	.product-detail {
		flex-direction: column;
	}
	.product-image-box, .product-info {
		width: 100%;
	}
	.product-info {
		padding: 30px;
	}
}
</style>

</head>

<body>


	<div class="header">

		<div class="logo">Campamela</div>

		<div class="menu">

			<a href="${pageContext.request.contextPath}/home"> Trang chủ </a>

			<a href="${pageContext.request.contextPath}/product"> Sản phẩm </a> <a
				href="#"> Danh mục </a> <a
				href="${pageContext.request.contextPath}/login"> Đăng nhập </a>

		</div>

	</div>



	<div class="container">

		<div class="product-detail">

			<!-- IMAGE -->

			<div class="product-image-box">

				<img src="${product.images}" alt="${product.productname}">

			</div>



			<div class="product-info">

				<h1 class="product-name">${product.productname}</h1>

				<div class="line"></div>


				<div class="product-description">${product.description}</div>


				<div class="product-price">

					<fmt:formatNumber value="${product.price}" type="number"
						groupingUsed="true" maxFractionDigits="0" />

					VNĐ

				</div>


				<a href="${pageContext.request.contextPath}/product"
					class="back-button"> ← Quay lại danh sách </a>

			</div>

		</div>

	</div>

</body>

</html>