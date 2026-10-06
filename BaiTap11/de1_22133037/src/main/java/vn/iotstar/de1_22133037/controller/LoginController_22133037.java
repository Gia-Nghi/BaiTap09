package vn.iotstar.de1_22133037.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.de1_22133037.entity.User_22133037;
import vn.iotstar.de1_22133037.service.UserService_22133037;

import java.io.IOException;

@WebServlet("/login")
public class LoginController_22133037
        extends HttpServlet {

    private final UserService_22133037 service =
            new UserService_22133037();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/WEB-INF/views/login.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        User_22133037 user =
                service.login(
                        email,
                        password
                );

        if (user == null) {

            request.setAttribute(
                    "error",
                    "Email hoặc mật khẩu không đúng!"
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/login.jsp"
            ).forward(request, response);

            return;
        }

        service.updateLastLogin(user);

        HttpSession session =
                request.getSession();

        session.setAttribute(
                "currentUser",
                user
        );

        if (Boolean.TRUE.equals(
                user.getIsAdmin())) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/admin/books"
            );

        } else {

            response.sendRedirect(
                    request.getContextPath()
                    + "/home"
            );
        }
    }
}