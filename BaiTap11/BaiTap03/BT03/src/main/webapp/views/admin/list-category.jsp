<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý danh mục</title>

<style>
body {
	margin: 0;
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
}

.container {
	width: 90%;
	margin: 30px auto;
	background: white;
	padding: 25px;
	box-shadow: 0 0 5px #ccc;
}

h2 {
	color: red;
	font-weight: normal;
	margin-bottom: 5px;
}

.description {
	color: #777;
	margin-bottom: 25px;
}

.top-bar {
	background: #f5f5f5;
	border: 1px solid #ddd;
	padding: 12px;
	margin-bottom: 0;
}

.add-button {
	display: inline-block;
	background: #337ab7;
	color: white;
	text-decoration: none;
	padding: 8px 15px;
	border-radius: 4px;
	margin-bottom: 15px;
}

.add-button:hover {
	background: #286090;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background-color: #f5f5f5;
	text-align: left;
	padding: 10px;
	border: 1px solid #ddd;
}

td {
	padding: 10px;
	border: 1px solid #ddd;
	vertical-align: middle;
}

.category-image {
	width: 100px;
	height: 100px;
	object-fit: contain;
}

.action a {
	color: #337ab7;
	text-decoration: none;
}

.action a:hover {
	text-decoration: underline;
}

.number {
	width: 50px;
}

.image-column {
	width: 250px;
}

.name-column {
	width: 30%;
}

.action-column {
	width: 150px;
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
</style>
</head>

<body>

	<!-- HEADER PHẢI NẰM Ở ĐÂY -->
	<div class="header">

		<div class="logo">Campanula - Quản lý danh mục</div>

		<div class="menu">

			<a href="${pageContext.request.contextPath}/home"> Trang chủ </a> <a
				href="${pageContext.request.contextPath}/product"> Xem cửa hàng
			</a> <a href="${pageContext.request.contextPath}/manage-product">
				Quản lý sản phẩm </a> <a
				href="${pageContext.request.contextPath}/logout"> Đăng xuất </a>

		</div>

	</div>


	<div class="container">

		<h2>Quản lý danh mục</h2>

		<div class="description">Nơi bạn có thể quản lý danh mục của
			mình</div>

		<a class="add-button"
			href="${pageContext.request.contextPath}/admin/category/add"> +
			Thêm danh mục mới </a>
		<div class="top-bar">Danh sách danh mục</div>

		<table>
			<thead>
				<tr>
					<th class="number">STT</th>
					<th class="image-column">Hình ảnh</th>
					<th class="name-column">Tên danh mục</th>
					<th class="action-column">Hành động</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${cateList}" var="cate" varStatus="STT">
					<tr>
						<td>${STT.index + 1}</td>

						<td><c:url value="/image?fname=${cate.icon}" var="imgUrl" />
							<img class="category-image" src="${imgUrl}" alt="${cate.name}">
						</td>

						<td>${cate.name}</td>

						<td class="action"><a
							href="<c:url value='/admin/category/edit?id=${cate.id}'/>">
								Sửa </a> | <a
							href="<c:url value='/admin/category/delete?id=${cate.id}'/>"
							onclick="return confirm('Bạn có chắc muốn xóa danh mục này không?');">
								Xóa </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>

</html>