package vn.iotstar.de1_22133037.controller;


import vn.iotstar.de1_22133037.entity.CartItem_22133037;
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
import java.util.Map;

@WebServlet("/checkout")
public class CheckoutController_22133037
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

        Map<Integer, CartItem_22133037> cart =
                (Map<Integer, CartItem_22133037>)
                        session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/cart"
            );

            return;
        }

        request.setAttribute(
                "cart",
                cart
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/user/checkout.jsp"
        ).forward(
                request,
                response
        );
    }

    @Override
    protected void doPost(
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

        Map<Integer, CartItem_22133037> cart =
                (Map<Integer, CartItem_22133037>)
                        session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/cart"
            );

            return;
        }

        String receiverName =
                request.getParameter(
                        "receiverName"
                );

        String receiverPhone =
                request.getParameter(
                        "receiverPhone"
                );

        String shippingAddress =
                request.getParameter(
                        "shippingAddress"
                );

        boolean success =
                orderService.createOrder(
                        user.getId(),
                        receiverName,
                        receiverPhone,
                        shippingAddress,
                        cart
                );

        if (success) {

            session.removeAttribute(
                    "cart"
            );

            response.sendRedirect(
                    request.getContextPath()
                    + "/orders"
            );

        } else {

            request.setAttribute(
                    "error",
                    "Đặt hàng thất bại! " +
                    "Sản phẩm có thể đã hết hàng."
            );

            request.setAttribute(
                    "cart",
                    cart
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/user/checkout.jsp"
            ).forward(
                    request,
                    response
            );
        }
    }
}