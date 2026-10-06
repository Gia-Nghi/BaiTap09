package vn.iotstar.de1_22133037.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.de1_22133037.service.BookService_22133037;

import java.io.IOException;

@WebServlet("/home")
public class HomeController_22133037
        extends HttpServlet {

    private final BookService_22133037 service =
            new BookService_22133037();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int page = 1;

        String pageParam =
                request.getParameter("page");

        if (pageParam != null) {

            try {
                page = Integer.parseInt(pageParam);
            } catch (NumberFormatException ignored) {
            }
        }

        int size = 6;

        long total =
                service.count();

        int totalPages =
                (int) Math.ceil(
                        (double) total / size
                );

        if (page < 1)
            page = 1;

        if (page > totalPages && totalPages > 0)
            page = totalPages;

        request.setAttribute(
                "books",
                service.findAll(page, size)
        );

        request.setAttribute(
                "currentPage",
                page
        );

        request.setAttribute(
                "totalPages",
                totalPages
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/home.jsp"
        ).forward(request, response);
    }
}