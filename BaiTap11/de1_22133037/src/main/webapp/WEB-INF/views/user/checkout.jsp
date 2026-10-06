<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<html>

<head>

    <title>Thanh toán</title>

    <style>

        .checkout {
            width: 700px;
            margin: auto;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input,
        textarea {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        textarea {
            height: 100px;
        }

        .error {
            color: red;
        }

    </style>

</head>

<body>

<div class="checkout">

    <h2>
        THANH TOÁN ĐƠN HÀNG
    </h2>

    <c:if test="${not empty error}">

        <p class="error">
            ${error}
        </p>

    </c:if>

    <form
        action="${pageContext.request.contextPath}/checkout"
        method="post">

        <div class="form-group">

            <label>
                Họ tên người nhận:
            </label>

            <input
                type="text"
                name="receiverName"
                required>

        </div>

        <div class="form-group">

            <label>
                Số điện thoại:
            </label>

            <input
                type="text"
                name="receiverPhone"
                required>

        </div>

        <div class="form-group">

            <label>
                Địa chỉ nhận hàng:
            </label>

            <textarea
                name="shippingAddress"
                required></textarea>

        </div>

        <div class="form-group">

            <label>
                Phương thức thanh toán:
            </label>

            <input
                type="radio"
                name="paymentMethod"
                value="COD"
                checked
                style="width:auto">

            Thanh toán khi nhận hàng (COD)

        </div>

        <hr>

        <h3>
            Sản phẩm
        </h3>

        <c:set
            var="total"
            value="0" />

        <c:forEach
            var="item"
            items="${cart.values()}">

            <p>

                ${item.book.title}

                &nbsp; × &nbsp;

                ${item.quantity}

                &nbsp; = &nbsp;

                ${item.subtotal}

            </p>

            <c:set
                var="total"
                value="${total + item.subtotal}" />

        </c:forEach>

        <hr>

        <h3>
            Tổng tiền:
            ${total}
        </h3>

        <button type="submit">
            ĐẶT HÀNG
        </button>

        &nbsp;

        <a
            href="${pageContext.request.contextPath}/cart">

            Quay lại giỏ hàng

        </a>

    </form>

</div>

</body>

</html>