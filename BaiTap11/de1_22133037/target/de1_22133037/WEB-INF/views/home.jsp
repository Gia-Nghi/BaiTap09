<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<h1>
    Danh sách sách
</h1>

<div class="book-grid">

    <c:forEach
            var="book"
            items="${books}">

        <div class="book-card">

            <img
                src="${pageContext.request.contextPath}/images/${book.coverImage}"
                alt="${book.title}"
                onerror="this.src='https://via.placeholder.com/180x240?text=BOOK'">

            <h3>

                <a href="${pageContext.request.contextPath}/book-detail?id=${book.bookid}">

                    ${book.title}

                </a>

            </h3>

            <p>
                <b>Mã ISBN:</b>
                ${book.isbn}
            </p>

            <p>

                <b>Tác giả:</b>

                <c:forEach
                        var="author"
                        items="${book.authors}"
                        varStatus="status">

                    ${author.authorName}

                    <c:if test="${!status.last}">
                        ,
                    </c:if>

                </c:forEach>

            </p>

            <p>
                <b>Publisher:</b>
                ${book.publisher}
            </p>

            <p>
                <b>Publisher_date:</b>
                ${book.publishDate}
            </p>

            <p>
                <b>Quantity:</b>
                ${book.quantity}
            </p>

        </div>

    </c:forEach>

</div>

<div class="pagination">

    <c:if test="${currentPage > 1}">

        <a href="${pageContext.request.contextPath}/home?page=${currentPage - 1}">
            &laquo; Trước
        </a>

    </c:if>

    <c:forEach
            begin="1"
            end="${totalPages}"
            var="p">

        <a class="${p == currentPage ? 'active' : ''}"
           href="${pageContext.request.contextPath}/home?page=${p}">

            ${p}

        </a>

    </c:forEach>

    <c:if test="${currentPage < totalPages}">

        <a href="${pageContext.request.contextPath}/home?page=${currentPage + 1}">
            Sau &raquo;
        </a>

    </c:if>

</div>