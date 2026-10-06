<%@ page contentType="text/html; charset=UTF-8" %>

<h1>
    ${empty author ? 'Thêm Author' : 'Cập nhật Author'}
</h1>

<form method="post"
      action="${pageContext.request.contextPath}/admin/authors">

    <input
            type="hidden"
            name="authorId"
            value="${author.authorId}">

    <label>
        Tên tác giả
    </label>

    <input
            type="text"
            name="authorName"
            value="${author.authorName}"
            required>

    <label>
        Ngày sinh
    </label>

    <input
            type="date"
            name="dateOfBirth"
            value="${author.dateOfBirth}">

    <button type="submit">
        Lưu
    </button>

</form>