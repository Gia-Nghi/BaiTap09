<%@ page contentType="text/html; charset=UTF-8" %>

<h1>
    ${empty book ? 'Thêm sách' : 'Cập nhật sách'}
</h1>

<form method="post"
      action="${pageContext.request.contextPath}/admin/books">

    <input
            type="hidden"
            name="bookid"
            value="${book.bookid}">

    <label>
        ISBN
    </label>

    <input
            type="number"
            name="isbn"
            value="${book.isbn}"
            required>

    <label>
        Tiêu đề
    </label>

    <input
            type="text"
            name="title"
            value="${book.title}"
            required>

    <label>
        Publisher
    </label>

    <input
            type="text"
            name="publisher"
            value="${book.publisher}">

    <label>
        Price
    </label>

    <input
            type="number"
            step="0.01"
            name="price"
            value="${book.price}">

    <label>
        Description
    </label>

    <textarea
            name="description"
            rows="5">${book.description}</textarea>

    <label>
        Publish date
    </label>

    <input
            type="date"
            name="publishDate"
            value="${book.publishDate}">

    <label>
        Cover image
    </label>

    <input
            type="text"
            name="coverImage"
            value="${book.coverImage}">

    <label>
        Quantity
    </label>

    <input
            type="number"
            name="quantity"
            value="${book.quantity}">

    <button type="submit">
        Lưu
    </button>

</form>