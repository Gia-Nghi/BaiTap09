<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<h1>
    Chi tiết sách
</h1>

<div class="detail">

    <div>

        <img
            class="detail-image"
            src="${pageContext.request.contextPath}/images/${book.coverImage}"
            onerror="this.src='https://via.placeholder.com/250x330?text=BOOK'">

    </div>

    <div>

        <h2>
            ${book.title}
        </h2>

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

        <p>
            <b>Reviews:</b>
            ${reviewCount}
        </p>

        <p>
            <b>Average:</b>
            ${averageRating}/5
        </p>

        <p>
            ${book.description}
        </p>

    </div>

</div>

<hr>

<h2>
    Reviews
</h2>

<c:choose>

    <c:when test="${empty reviews}">

        <p>
            Chưa có review.
        </p>

    </c:when>

    <c:otherwise>

        <c:forEach
                var="review"
                items="${reviews}">

            <div class="review">

                <b>
                    ${review.user.fullname}
                </b>

                <span>
                    - ${review.rating}/5
                </span>

                <p>
                    ${review.reviewText}
                </p>

            </div>

        </c:forEach>

    </c:otherwise>

</c:choose>

<hr>

<h2>
    Thêm Review
</h2>

<c:choose>

    <c:when test="${not empty sessionScope.currentUser}">

        <form method="post"
              action="${pageContext.request.contextPath}/review">

            <input
                    type="hidden"
                    name="bookid"
                    value="${book.bookid}">

            <label>
                Rating
            </label>

            <select name="rating">

                <option value="5">5 - Rất tốt</option>
                <option value="4">4 - Tốt</option>
                <option value="3">3 - Bình thường</option>
                <option value="2">2 - Không tốt</option>
                <option value="1">1 - Rất tệ</option>

            </select>

            <label>
                Review
            </label>

            <textarea
                    name="reviewText"
                    rows="5"
                    required></textarea>

            <button type="submit">
                Submit
            </button>

        </form>

    </c:when>

    <c:otherwise>

        <p>
            Vui lòng
            <a href="${pageContext.request.contextPath}/login">
                đăng nhập
            </a>
            để viết review.
        </p>

    </c:otherwise>

</c:choose>