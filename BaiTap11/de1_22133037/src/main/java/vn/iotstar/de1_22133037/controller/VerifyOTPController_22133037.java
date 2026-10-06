package vn.iotstar.de1_22133037.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iotstar.de1_22133037.entity.User_22133037;
import vn.iotstar.de1_22133037.service.UserService_22133037;

import java.io.IOException;

@WebServlet("/verify-otp")
public class VerifyOTPController_22133037
        extends HttpServlet {

    private final UserService_22133037 service =
            new UserService_22133037();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/WEB-INF/views/verify-otp.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        String inputOTP =
                request.getParameter("otp");

        String sessionOTP =
                (String) session.getAttribute(
                        "registerOTP"
                );

        Long otpTime =
                (Long) session.getAttribute(
                        "otpTime"
                );

        if (sessionOTP == null ||
                otpTime == null) {

            request.setAttribute(
                    "error",
                    "OTP không tồn tại!"
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/verify-otp.jsp"
            ).forward(request, response);

            return;
        }

        long now =
                System.currentTimeMillis();

        if (now - otpTime >
                5 * 60 * 1000) {

            request.setAttribute(
                    "error",
                    "OTP đã hết hạn!"
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/verify-otp.jsp"
            ).forward(request, response);

            return;
        }

        if (!sessionOTP.equals(inputOTP)) {

            request.setAttribute(
                    "error",
                    "OTP không đúng!"
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/verify-otp.jsp"
            ).forward(request, response);

            return;
        }

        User_22133037 user =
                new User_22133037();

        user.setEmail(
                (String) session.getAttribute(
                        "registerEmail"
                )
        );

        user.setFullname(
                (String) session.getAttribute(
                        "registerFullname"
                )
        );

        String phone =
                (String) session.getAttribute(
                        "registerPhone"
                );

        if (phone != null &&
                !phone.isEmpty()) {

            user.setPhone(
                    Integer.parseInt(phone)
            );
        }

        user.setPasswd(
                (String) session.getAttribute(
                        "registerPassword"
                )
        );

        user.setIsAdmin(false);

        service.register(user);

        session.removeAttribute("registerOTP");
        session.removeAttribute("otpTime");
        session.removeAttribute("registerEmail");
        session.removeAttribute("registerFullname");
        session.removeAttribute("registerPhone");
        session.removeAttribute("registerPassword");

        response.sendRedirect(
                request.getContextPath()
                + "/login?registered=true"
        );
    }
}