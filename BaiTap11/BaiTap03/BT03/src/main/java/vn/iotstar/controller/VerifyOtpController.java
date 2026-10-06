package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/verify-otp")
public class VerifyOtpController extends HttpServlet {

	private UserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/verify-otp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String email = req.getParameter("email");
		String otp = req.getParameter("otp");

		HttpSession session = req.getSession();

		String otpType = (String) session.getAttribute("otpType");

		if ("forgot".equals(otpType)) {

			email = (String) session.getAttribute("forgotEmail");

		}

		if (email == null || email.isEmpty() || otp == null || otp.isEmpty()) {

			req.setAttribute("alert", "Vui lòng nhập đầy đủ thông tin!");

			req.getRequestDispatcher("/views/verify-otp.jsp").forward(req, resp);

			return;
		}

		boolean result = service.verifyOtp(email, otp);

		if (result) {

			if ("register".equals(otpType)) {

				session.removeAttribute("otpType");

				resp.sendRedirect(req.getContextPath() + "/login");

			}

			else if ("forgot".equals(otpType)) {

				session.setAttribute("resetEmail", email);

				session.removeAttribute("otpType");
				session.removeAttribute("forgotEmail");

				resp.sendRedirect(req.getContextPath() + "/reset-password");
			}

		} else {

			req.setAttribute("alert", "OTP không đúng hoặc đã hết hạn!");

			req.getRequestDispatcher("/views/verify-otp.jsp").forward(req, resp);
		}
	}
}