<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<html>
<head>

    <title>Giỏ hàng</title>

    <style>

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }

        .cart-title {
            margin-bottom: 20px;
        }

        .btn {
            padding: 7px 12px;
            text-decoration: none;
        }

    </style>

</head>

<body>

<h2 class="cart-title">
    GIỎ HÀNG
</h2>

<c:choose>

    <c:when test="${empty cart}">

        <p>
            Giỏ hàng đang trống.
        </p>

        <a href="${pageContext.request.contextPath}/home">
            Tiếp tục mua sách
        </a>

    </c:when>

    <c:otherwise>

        <table>

            <tr>

                <th>
                    Sách
                </th>

                <th>
                    Đơn giá
                </th>

                <th>
                    Số lượng
                </th>

                <th>
                    Thành tiền
                </th>

                <th>
                    Thao tác
                </th>

            </tr>

            <c:set var="total"
                     value="0" />

            <c:forEach
                    var="item"
                    items="${cart.values()}">

                <tr>

                    <td>

                        ${item.book.title}

                    </td>

                    <td>

                        ${item.book.price}

                    </td>

                    <td>

                        <form
                            action="${pageContext.request.contextPath}/cart/update"
                            method="post">

                            <input
                                type="hidden"
                                name="bookId"
                                value="${item.book.bookid}">

                            <input
                                type="number"
                                name="quantity"
                                value="${item.quantity}"
                                min="1"
                                max="${item.book.quantity}"
                                required>

                            <button type="submit">
                                Cập nhật
                            </button>

                        </form>

                    </td>

                    <td>

                        ${item.subtotal}

                    </td>

                    <td>

                        <a
                            class="btn"
                            href="${pageContext.request.contextPath}/cart/delete?bookId=${item.book.bookid}">

                            Xóa

                        </a>

                    </td>

                </tr>

                <c:set
                    var="total"
                    value="${total + item.subtotal}" />

            </c:forEach>

        </table>

        <br>

        <h3>
            Tổng tiền:
            ${total}
        </h3>

        <a
            href="${pageContext.request.contextPath}/home">

            Tiếp tục mua hàng

        </a>

        &nbsp;&nbsp;

        <a
            href="${pageContext.request.contextPath}/checkout">

            Thanh toán COD

        </a>

    </c:otherwise>

</c:choose>

</body>
</html>