package vn.iotstar.de1_22133037.controller;

import vn.iotstar.de1_22133037.entity.Book_22133037;
import vn.iotstar.de1_22133037.entity.CartItem_22133037;
import vn.iotstar.de1_22133037.service.BookService_22133037;
import vn.iotstar.de1_22133037.service.CartService_22133037;
import vn.iotstar.de1_22133037.service.CartServiceImpl_22133037;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/cart")
public class CartController_22133037 extends HttpServlet {

    private BookService_22133037 bookService;

    private CartService_22133037 cartService;

    @Override
    public void init() {

        bookService = new BookService_22133037();

        cartService = new CartServiceImpl_22133037();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // Thêm sách vào giỏ hàng
        if ("add".equals(action)) {

            addToCart(request);

            response.sendRedirect(
                    request.getContextPath() + "/cart"
            );

            return;
        }

        // Hiển thị giỏ hàng
        HttpSession session = request.getSession();

        Map<Integer, CartItem_22133037> cart =
                getCart(session);

        request.setAttribute(
                "cart",
                cart
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/user/cart.jsp"
        ).forward(request, response);
    }

    private void addToCart(
            HttpServletRequest request) {

        String bookIdParam =
                request.getParameter("bookId");

        if (bookIdParam == null ||
                bookIdParam.isEmpty()) {

            return;
        }

        int bookId;

        try {

            bookId = Integer.parseInt(bookIdParam);

        } catch (NumberFormatException e) {

            return;
        }

        Book_22133037 book =
                bookService.findById(bookId);

        if (book == null) {

            return;
        }

        HttpSession session =
                request.getSession();

        Map<Integer, CartItem_22133037> cart =
                getCart(session);

        cartService.addToCart(
                cart,
                book
        );
    }

    @SuppressWarnings("unchecked")
    private Map<Integer, CartItem_22133037> getCart(
            HttpSession session) {

        Map<Integer, CartItem_22133037> cart =
                (Map<Integer, CartItem_22133037>)
                        session.getAttribute("cart");

        if (cart == null) {

            cart = new LinkedHashMap<>();

            session.setAttribute(
                    "cart",
                    cart
            );
        }

        return cart;
    }
}