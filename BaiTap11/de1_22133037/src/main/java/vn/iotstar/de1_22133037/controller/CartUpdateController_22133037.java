package vn.iotstar.de1_22133037.controller;


import vn.iotstar.de1_22133037.entity.CartItem_22133037;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.de1_22133037.service.CartService_22133037;
import vn.iotstar.de1_22133037.service.CartServiceImpl_22133037;

import java.io.IOException;
import java.util.Map;

@WebServlet("/cart/update")
public class CartUpdateController_22133037
        extends HttpServlet {

    private CartService_22133037 cartService =
            new CartServiceImpl_22133037();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int bookId =
                Integer.parseInt(
                        request.getParameter("bookId")
                );

        int quantity =
                Integer.parseInt(
                        request.getParameter("quantity")
                );

        HttpSession session =
                request.getSession();

        Map<Integer, CartItem_22133037> cart =
                (Map<Integer, CartItem_22133037>)
                        session.getAttribute("cart");

        if (cart != null) {

            cartService.updateQuantity(
                    cart,
                    bookId,
                    quantity
            );
        }

        response.sendRedirect(
                request.getContextPath()
                + "/cart"
        );
    }
}