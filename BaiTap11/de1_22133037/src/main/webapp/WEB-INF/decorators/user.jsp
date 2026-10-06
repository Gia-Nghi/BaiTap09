<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>
        Thư viện sách - Đề 1
    </title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<header>

    <div class="container header">

        <h2>
            BOOK STORE
        </h2>

        <nav>

            <a href="${pageContext.request.contextPath}/home">
                Trang Chủ
            </a>

            <a href="${pageContext.request.contextPath}/home">
                Sản phẩm
            </a>

            <c:choose>

                <c:when test="${not empty sessionScope.currentUser}">

                    <span>
                        Xin chào:
                        ${sessionScope.currentUser.fullname}
                    </span>

                    <a href="${pageContext.request.contextPath}/logout">
                        Đăng xuất
                    </a>

                    <c:if test="${sessionScope.currentUser.isAdmin}">
                        <a href="${pageContext.request.contextPath}/admin/books">
                            Trang quản trị
                        </a>
                    </c:if>

                </c:when>

                <c:otherwise>

                    <a href="${pageContext.request.contextPath}/login">
                        Đăng nhập
                    </a>

                    <a href="${pageContext.request.contextPath}/register">
                        Đăng ký
                    </a>

                </c:otherwise>

            </c:choose>

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