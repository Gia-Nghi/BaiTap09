<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Trang chủ - Campanula</title>

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
	width: 90%;
	margin: 40px auto;
}

.title {
	text-align: center;
	margin-bottom: 40px;
	color: #2c3e50;
	font-size: 32px;
}

.product-grid {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
	gap: 25px;
}

.product-card {
	background: white;
	border-radius: 12px;
	overflow: hidden;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
	transition: 0.3s;
}

.product-card:hover {
	transform: translateY(-8px);
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
}

.product-image {
	width: 100%;
	height: 220px;
	object-fit: cover;
	background: #eee;
}

.product-info {
	padding: 20px;
}

.product-name {
	font-size: 20px;
	font-weight: bold;
	color: #2c3e50;
	margin-bottom: 10px;
	min-height: 48px;
}

.product-description {
	color: #777;
	height: 45px;
	overflow: hidden;
	margin-bottom: 15px;
	line-height: 22px;
}

.product-price {
	color: #e74c3c;
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 20px;
}

/* BUTTON */
.product-button {
	display: block;
	text-align: center;
	background: #3498db;
	color: white;
	padding: 12px;
	border-radius: 6px;
	text-decoration: none;
	transition: 0.3s;
}

.product-button:hover {
	background: #2980b9;
}

.empty {
	text-align: center;
	font-size: 20px;
	color: #777;
}

.view-all {
	text-align: center;
	margin-top: 40px;
}

.view-all a {
	display: inline-block;
	background: #2c3e50;
	color: white;
	padding: 14px 30px;
	border-radius: 6px;
	text-decoration: none;
}

.view-all a:hover {
	background: #34495e;
}
</style>

</head>

<body>


	<div class="header">

		<div class="logo">Campanula</div>

		<div class="menu">

			<a href="${pageContext.request.contextPath}/home"> Trang chủ </a> <a
				href="${pageContext.request.contextPath}/product"> Sản phẩm </a> <a></a>
			
			<c:choose>
				<c:when test="${not empty sessionScope.account}">
	
					<a href="${pageContext.request.contextPath}/admin/category/list">
						Quản lý danh mục </a>
				</c:when>

				<c:otherwise>
					<a href="${pageContext.request.contextPath}/login"> Quản lý danh mục </a>
				</c:otherwise>
			</c:choose>
			
			<c:choose>

				<c:when test="${not empty sessionScope.account}">

					<a href="${pageContext.request.contextPath}/manage-product">
						Quản lý sản phẩm </a>

					<a href="${pageContext.request.contextPath}/logout"> Đăng xuất
					</a>

				</c:when>

				<c:otherwise>

					<a href="${pageContext.request.contextPath}/login"> Đăng nhập </a>

					<a href="${pageContext.request.contextPath}/register"> Đăng ký
					</a>

				</c:otherwise>

			</c:choose>
		</div>

	</div>


	<!-- CONTENT -->

	<div class="container">

		<h1 class="title">SẢN PHẨM MỚI NHẤT</h1>


		<c:if test="${empty productList}">

			<div class="empty">Chưa có sản phẩm nào!</div>

		</c:if>


		<div class="product-grid">

			<c:forEach items="${productList}" var="product">

				<div class="product-card">

					<c:choose>

						<c:when test="${not empty product.images}">

							<img src="${product.images}" class="product-image"
								onerror="this.onerror=null;
                                this.src='https://placehold.co/300x220?text=No+Image';">

						</c:when>


						<c:otherwise>

							<img src="https://placehold.co/300x220?text=No+Image"
								class="product-image">

						</c:otherwise>

					</c:choose>


					<!-- INFO -->

					<div class="product-info">

						<div class="product-name">${product.productname}</div>


						<div class="product-description">${product.description}</div>


						<div class="product-price">

							<fmt:formatNumber value="${product.price}" type="number"
								groupingUsed="true" maxFractionDigits="0" />

							VNĐ

						</div>


						<a
							href="${pageContext.request.contextPath}/product-detail?id=${product.id}"
							class="product-button"> Xem chi tiết </a>

					</div>

				</div>

			</c:forEach>

		</div>


		<div class="view-all">

			<a href="${pageContext.request.contextPath}/product"> Xem tất cả
				sản phẩm </a>

		</div>

	</div>

</body>
</html>