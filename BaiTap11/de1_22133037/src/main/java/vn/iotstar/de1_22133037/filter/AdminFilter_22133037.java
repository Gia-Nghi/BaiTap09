package vn.iotstar.de1_22133037.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import vn.iotstar.de1_22133037.entity.User_22133037;

import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter_22133037
        implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse res =
                (HttpServletResponse) response;

        HttpSession session =
                req.getSession(false);

        if (session == null) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/login"
            );

            return;
        }

        User_22133037 user =
                (User_22133037)
                        session.getAttribute(
                                "currentUser"
                        );

        if (user == null ||
                !Boolean.TRUE.equals(
                        user.getIsAdmin()
                )) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/home"
            );

            return;
        }

        chain.doFilter(
                request,
                response
        );
    }
}