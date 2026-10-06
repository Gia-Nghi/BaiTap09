<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<h1>
    Quản lý Books
</h1>

<a class="btn"
   href="${pageContext.request.contextPath}/admin/books?action=add">

    + Thêm sách

</a>

<br>
<br>

<table>

    <thead>

    <tr>

        <th>ID</th>
        <th>ISBN</th>
        <th>Title</th>
        <th>Publisher</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Action</th>

    </tr>

    </thead>

    <tbody>

    <c:forEach
            var="book"
            items="${books}">

        <tr>

            <td>
                ${book.bookid}
            </td>

            <td>
                ${book.isbn}
            </td>

            <td>
                ${book.title}
            </td>

            <td>
                ${book.publisher}
            </td>

            <td>
                ${book.price}
            </td>

            <td>
                ${book.quantity}
            </td>

            <td>

                <a href="${pageContext.request.contextPath}/admin/books?action=edit&id=${book.bookid}">
                    Sửa
                </a>

                |

                <a
                    href="${pageContext.request.contextPath}/admin/books?action=delete&id=${book.bookid}"
                    onclick="return confirm('Bạn có chắc muốn xóa?')">

                    Xóa

                </a>

            </td>

        </tr>

    </c:forEach>

    </tbody>

</table>

<div class="pagination">

    <c:forEach
            begin="1"
            end="${totalPages}"
            var="p">

        <a
            class="${p == currentPage ? 'active' : ''}"
            href="${pageContext.request.contextPath}/admin/books?page=${p}">

            ${p}

        </a>

    </c:forEach>

</div>