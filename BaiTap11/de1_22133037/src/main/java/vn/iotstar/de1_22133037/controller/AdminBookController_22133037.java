package vn.iotstar.de1_22133037.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iotstar.de1_22133037.entity.Book_22133037;
import vn.iotstar.de1_22133037.service.BookService_22133037;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet("/admin/books")
public class AdminBookController_22133037
        extends HttpServlet {

    private final BookService_22133037 service =
            new BookService_22133037();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        if ("delete".equals(action)) {

            Integer id =
                    Integer.parseInt(
                            request.getParameter("id")
                    );

            service.delete(id);

            response.sendRedirect(
                    request.getContextPath()
                    + "/admin/books"
            );

            return;
        }

        if ("edit".equals(action)) {

            Integer id =
                    Integer.parseInt(
                            request.getParameter("id")
                    );

            request.setAttribute(
                    "book",
                    service.findById(id)
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/admin/book-form.jsp"
            ).forward(request, response);

            return;
        }

        if ("add".equals(action)) {

            request.getRequestDispatcher(
                    "/WEB-INF/views/admin/book-form.jsp"
            ).forward(request, response);

            return;
        }

        int page = 1;

        try {

            page =
                    Integer.parseInt(
                            request.getParameter("page")
                    );

        } catch (Exception ignored) {
        }

        int size = 5;

        long total =
                service.count();

        int totalPages =
                (int) Math.ceil(
                        (double) total / size
                );

        request.setAttribute(
                "books",
                service.findAll(
                        page,
                        size
                )
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
                "/WEB-INF/views/admin/books.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String id =
                request.getParameter("bookid");

        Book_22133037 book =
                new Book_22133037();

        if (id != null &&
                !id.isEmpty()) {

            book.setBookid(
                    Integer.parseInt(id)
            );
        }

        book.setIsbn(
                Integer.parseInt(
                        request.getParameter(
                                "isbn"
                        )
                )
        );

        book.setTitle(
                request.getParameter("title")
        );

        book.setPublisher(
                request.getParameter(
                        "publisher"
                )
        );

        book.setPrice(
                new BigDecimal(
                        request.getParameter(
                                "price"
                        )
                )
        );

        book.setDescription(
                request.getParameter(
                        "description"
                )
        );

        book.setPublishDate(
                LocalDate.parse(
                        request.getParameter(
                                "publishDate"
                        )
                )
        );

        book.setCoverImage(
                request.getParameter(
                        "coverImage"
                )
        );

        book.setQuantity(
                Integer.parseInt(
                        request.getParameter(
                                "quantity"
                        )
                )
        );

        if (id == null ||
                id.isEmpty()) {

            service.save(book);

        } else {

            service.update(book);
        }

        response.sendRedirect(
                request.getContextPath()
                + "/admin/books"
        );
    }
}