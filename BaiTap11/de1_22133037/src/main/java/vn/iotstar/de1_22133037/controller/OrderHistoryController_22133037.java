package vn.iotstar.de1_22133037.controller;


import vn.iotstar.de1_22133037.entity.Order_22133037;
import vn.iotstar.de1_22133037.entity.User_22133037;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.de1_22133037.service.OrderService_22133037;
import vn.iotstar.de1_22133037.service.OrderServiceImpl_22133037;

import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class OrderHistoryController_22133037
        extends HttpServlet {

    private OrderService_22133037 orderService =
            new OrderServiceImpl_22133037();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        User_22133037 user =
                (User_22133037)
                        session.getAttribute("user");

        if (user == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/login"
            );

            return;
        }

        String status =
                request.getParameter("status");

        List<Order_22133037> orders;

        if (status == null
                || status.trim().isEmpty()) {

            orders =
                    orderService.findByUserId(
                            user.getId()
                    );

        } else {

            orders =
                    orderService
                            .findByUserIdAndStatus(
                                    user.getId(),
                                    status
                            );
        }

        request.setAttribute(
                "orders",
                orders
        );

        request.setAttribute(
                "currentStatus",
                status
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/user/orders.jsp"
        ).forward(
                request,
                response
        );
    }
}