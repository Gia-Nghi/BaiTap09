<%@ page contentType="text/html; charset=UTF-8" %>

<h2>
    Xác thực OTP
</h2>

<p>
    Mã OTP đã được gửi tới email:
    <b>${sessionScope.registerEmail}</b>
</p>

<c:if test="${not empty error}">

    <div class="error">
        ${error}
    </div>

</c:if>

<form method="post"
      action="${pageContext.request.contextPath}/verify-otp">

    <label>
        Nhập mã OTP
    </label>

    <input
            type="text"
            name="otp"
            maxlength="6"
            required>

    <button type="submit">
        Xác nhận
    </button>

</form>