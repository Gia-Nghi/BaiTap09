package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

@WebServlet("/forgot-password")
public class ForgotPasswordController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserService service =
            new UserServiceImpl();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher(
                "/views/forgot-password.jsp"
        ).forward(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String email =
                req.getParameter("email");

        boolean result =
                service.forgotPassword(email);

        if (result) {

            req.getSession().setAttribute(
                    "forgotEmail",
                    email
            );

            req.getSession().setAttribute("otpType", "forgot");

            resp.sendRedirect(
                req.getContextPath() + "/verify-otp"
            );

        } else {

            req.setAttribute(
                    "alert",
                    "Email không tồn tại!"
            );

            req.getRequestDispatcher(
                    "/views/forgot-password.jsp"
            ).forward(req, resp);
        }
    }
}