<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<h1>
    Quản lý Authors
</h1>

<a class="btn"
   href="${pageContext.request.contextPath}/admin/authors?action=add">

    + Thêm Author

</a>

<br>
<br>

<table>

    <thead>

    <tr>

        <th>ID</th>
        <th>Tên tác giả</th>
        <th>Ngày sinh</th>
        <th>Action</th>

    </tr>

    </thead>

    <tbody>

    <c:forEach
            var="author"
            items="${authors}">

        <tr>

            <td>
                ${author.authorId}
            </td>

            <td>
                ${author.authorName}
            </td>

            <td>
                ${author.dateOfBirth}
            </td>

            <td>

                <a href="${pageContext.request.contextPath}/admin/authors?action=edit&id=${author.authorId}">
                    Sửa
                </a>

                |

                <a
                    href="${pageContext.request.contextPath}/admin/authors?action=delete&id=${author.authorId}"
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
            href="${pageContext.request.contextPath}/admin/authors?page=${p}">

            ${p}

        </a>

    </c:forEach>

</div>