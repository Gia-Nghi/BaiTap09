<%@ page contentType="text/html; charset=UTF-8" %>

<h2>
    Đăng nhập
</h2>

<c:if test="${param.registered == 'true'}">

    <div class="success">
        Đăng ký thành công. Vui lòng đăng nhập!
    </div>

</c:if>

<c:if test="${not empty error}">

    <div class="error">
        ${error}
    </div>

</c:if>

<form method="post"
      action="${pageContext.request.contextPath}/login">

    <label>
        Email
    </label>

    <input
            type="email"
            name="email"
            required>

    <label>
        Mật khẩu
    </label>

    <input
            type="password"
            name="password"
            required>

    <button type="submit">
        Đăng nhập
    </button>

</form>

<p>

    Chưa có tài khoản?

    <a href="${pageContext.request.contextPath}/register">
        Đăng ký
    </a>

</p>