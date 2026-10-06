package vn.iotstar.de1_22133037.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iotstar.de1_22133037.entity.User_22133037;
import vn.iotstar.de1_22133037.service.MailService_22133037;
import vn.iotstar.de1_22133037.service.UserService_22133037;

import java.io.IOException;
import java.util.Random;

@WebServlet("/register")
public class RegisterController_22133037
        extends HttpServlet {

    private final UserService_22133037 userService =
            new UserService_22133037();

    private final MailService_22133037 mailService =
            new MailService_22133037();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/WEB-INF/views/register.jsp"
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

        String fullname =
                request.getParameter("fullname");

        String phone =
                request.getParameter("phone");

        String password =
                request.getParameter("password");

        User_22133037 old =
                userService.findByEmail(email);

        if (old != null) {

            request.setAttribute(
                    "error",
                    "Email đã tồn tại!"
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/register.jsp"
            ).forward(request, response);

            return;
        }

        String otp =
                String.format(
                        "%06d",
                        new Random().nextInt(1000000)
                );

        HttpSession session =
                request.getSession();

        session.setAttribute(
                "registerEmail",
                email
        );

        session.setAttribute(
                "registerFullname",
                fullname
        );

        session.setAttribute(
                "registerPhone",
                phone
        );

        session.setAttribute(
                "registerPassword",
                password
        );

        session.setAttribute(
                "registerOTP",
                otp
        );

        session.setAttribute(
                "otpTime",
                System.currentTimeMillis()
        );

        try {

            mailService.sendOTP(
                    email,
                    otp
            );

        } catch (Exception e) {

            request.setAttribute(
                    "error",
                    "Không gửi được email OTP: "
                    + e.getMessage()
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/register.jsp"
            ).forward(request, response);

            return;
        }

        response.sendRedirect(
                request.getContextPath()
                + "/verify-otp"
        );
    }
}