<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>
        Admin - Book Store
    </title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<header class="admin-header">

    <div class="container header">

        <h2>
            ADMIN - BOOK STORE
        </h2>

        <nav>

            <a href="${pageContext.request.contextPath}/home">
                Trang Chủ
            </a>

            <a href="${pageContext.request.contextPath}/home">
                Sản phẩm
            </a>

            <a href="${pageContext.request.contextPath}/admin/books">
                Quản lý Books
            </a>

            <a href="${pageContext.request.contextPath}/admin/authors">
                Quản lý Authors
            </a>

            <a href="${pageContext.request.contextPath}/logout">
                Đăng xuất
            </a>

        </nav>

    </div>

</header>

<main class="container">

    <sitemesh:write property="body"/>

</main>

<footer>

    <div class="container">

        <p>
            Họ tên: Vy Gia Nghi
        </p>

        <p>
            MSSV: 22133037
        </p>

        <p>
            Mã đề: 1
        </p>

    </div>

</footer>

</body>

</html>