<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<html>

<head>

    <title>Lịch sử đặt hàng</title>

    <style>

        .filter {
            margin-bottom: 25px;
        }

        .filter a {
            margin-right: 10px;
        }

        .order {
            border: 1px solid #ccc;
            padding: 15px;
            margin-bottom: 20px;
        }

        .status {
            font-weight: bold;
        }

    </style>

</head>

<body>

<h2>
    LỊCH SỬ ĐẶT HÀNG
</h2>

<div class="filter">

    <a
        href="${pageContext.request.contextPath}/orders">

        Tất cả

    </a>

    |

    <a
        href="${pageContext.request.contextPath}/orders?status=NEW">

        Đơn hàng mới

    </a>

    |

    <a
        href="${pageContext.request.contextPath}/orders?status=CONFIRMED">

        Đã xác nhận

    </a>

    |

    <a
        href="${pageContext.request.contextPath}/orders?status=PREPARING">

        Chuẩn bị hàng

    </a>

    |

    <a
        href="${pageContext.request.contextPath}/orders?status=SHIPPING">

        Vận chuyển

    </a>

    |

    <a
        href="${pageContext.request.contextPath}/orders?status=DELIVERING">

        Giao hàng

    </a>

    |

    <a
        href="${pageContext.request.contextPath}/orders?status=DELIVERED">

        Đã giao

    </a>

    |

    <a
        href="${pageContext.request.contextPath}/orders?status=CANCELLED">

        Đơn hàng hủy

    </a>

    |

    <a
        href="${pageContext.request.contextPath}/orders?status=RETURNED">

        Đơn hàng hoàn

    </a>

</div>

<c:choose>

    <c:when test="${empty orders}">

        <p>
            Không có đơn hàng.
        </p>

    </c:when>

    <c:otherwise>

        <c:forEach
            var="order"
            items="${orders}">

            <div class="order">

                <h3>
                    Đơn hàng #${order.orderId}
                </h3>

                <p>
                    Ngày đặt:
                    ${order.orderDate}
                </p>

                <p>
                    Người nhận:
                    ${order.receiverName}
                </p>

                <p>
                    Số điện thoại:
                    ${order.receiverPhone}
                </p>

                <p>
                    Địa chỉ:
                    ${order.shippingAddress}
                </p>

                <p>
                    Phương thức:
                    ${order.paymentMethod}
                </p>

                <p>
                    Tổng tiền:
                    ${order.totalAmount}
                </p>

                <p class="status">

                    Trạng thái:

                    <c:choose>

                        <c:when
                            test="${order.status == 'NEW'}">

                            Đơn hàng mới

                        </c:when>

                        <c:when
                            test="${order.status == 'CONFIRMED'}">

                            Đã xác nhận

                        </c:when>

                        <c:when
                            test="${order.status == 'PREPARING'}">

                            Chuẩn bị hàng

                        </c:when>

                        <c:when
                            test="${order.status == 'SHIPPING'}">

                            Vận chuyển

                        </c:when>

                        <c:when
                            test="${order.status == 'DELIVERING'}">

                            Giao hàng

                        </c:when>

                        <c:when
                            test="${order.status == 'DELIVERED'}">

                            Đã giao

                        </c:when>

                        <c:when
                            test="${order.status == 'CANCELLED'}">

                            Đơn hàng hủy

                        </c:when>

                        <c:when
                            test="${order.status == 'RETURNED'}">

                            Đơn hàng hoàn

                        </c:when>

                        <c:otherwise>

                            ${order.status}

                        </c:otherwise>

                    </c:choose>

                </p>

            </div>

        </c:forEach>

    </c:otherwise>

</c:choose>

</body>

</html>