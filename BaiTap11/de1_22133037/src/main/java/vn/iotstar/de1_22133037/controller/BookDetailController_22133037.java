package vn.iotstar.de1_22133037.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iotstar.de1_22133037.entity.Book_22133037;
import vn.iotstar.de1_22133037.service.BookService_22133037;
import vn.iotstar.de1_22133037.service.RatingService_22133037;

import java.io.IOException;

@WebServlet("/book-detail")
public class BookDetailController_22133037
        extends HttpServlet {

    private final BookService_22133037 bookService =
            new BookService_22133037();

    private final RatingService_22133037 ratingService =
            new RatingService_22133037();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String id =
                request.getParameter("id");

        if (id == null) {
            response.sendRedirect(
                    request.getContextPath()
                    + "/home"
            );
            return;
        }

        Integer bookId =
                Integer.parseInt(id);

        Book_22133037 book =
                bookService.findById(bookId);

        if (book == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/home"
            );

            return;
        }

        request.setAttribute(
                "book",
                book
        );

        request.setAttribute(
                "reviews",
                ratingService.findByBook(bookId)
        );

        request.setAttribute(
                "averageRating",
                ratingService.getAverageRating(bookId)
        );

        request.setAttribute(
                "reviewCount",
                ratingService.countByBook(bookId)
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/book-detail.jsp"
        ).forward(request, response);
    }
}