<%@ page contentType="text/html; charset=UTF-8" %>

<h2>
    Đăng ký tài khoản
</h2>

<c:if test="${not empty error}">

    <div class="error">
        ${error}
    </div>

</c:if>

<form method="post"
      action="${pageContext.request.contextPath}/register">

    <label>
        Họ tên
    </label>

    <input
            type="text"
            name="fullname"
            required>

    <label>
        Email
    </label>

    <input
            type="email"
            name="email"
            required>

    <label>
        Số điện thoại
    </label>

    <input
            type="number"
            name="phone">

    <label>
        Mật khẩu
    </label>

    <input
            type="password"
            name="password"
            required>

    <button type="submit">
        Gửi OTP
    </button>

</form>