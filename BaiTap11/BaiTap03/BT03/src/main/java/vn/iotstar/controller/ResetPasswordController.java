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
@WebServlet("/reset-password")
public class ResetPasswordController extends HttpServlet {

	private UserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("resetEmail") == null) {

			resp.sendRedirect(req.getContextPath() + "/forgot-password");

			return;
		}

		req.getRequestDispatcher("/views/reset-password.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String password = req.getParameter("password");

		String confirmPassword = req.getParameter("confirmPassword");

		HttpSession session = req.getSession(false);

		String email = (String) session.getAttribute("resetEmail");

		if (password == null || password.isEmpty() || confirmPassword == null || confirmPassword.isEmpty()) {

			req.setAttribute("alert", "Vui lòng nhập đầy đủ mật khẩu!");

			req.getRequestDispatcher("/views/reset-password.jsp").forward(req, resp);

			return;
		}

		if (!password.equals(confirmPassword)) {

			req.setAttribute("alert", "Hai mật khẩu không giống nhau!");

			req.getRequestDispatcher("/views/reset-password.jsp").forward(req, resp);

			return;
		}

		boolean result = service.resetPassword(email, password);

		if (result) {

			session.removeAttribute("resetEmail");

			resp.sendRedirect(req.getContextPath() + "/login");

		} else {

			req.setAttribute("alert", "Đổi mật khẩu thất bại!");

			req.getRequestDispatcher("/views/reset-password.jsp").forward(req, resp);
		}
	}
}