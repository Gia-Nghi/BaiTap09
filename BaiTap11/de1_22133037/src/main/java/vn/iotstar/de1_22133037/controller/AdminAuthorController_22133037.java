package vn.iotstar.de1_22133037.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iotstar.de1_22133037.entity.Author_22133037;
import vn.iotstar.de1_22133037.service.AuthorService_22133037;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/admin/authors")
public class AdminAuthorController_22133037
        extends HttpServlet {

    private final AuthorService_22133037 service =
            new AuthorService_22133037();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        if ("delete".equals(action)) {

            service.delete(
                    Integer.parseInt(
                            request.getParameter("id")
                    )
            );

            response.sendRedirect(
                    request.getContextPath()
                    + "/admin/authors"
            );

            return;
        }

        if ("edit".equals(action)) {

            request.setAttribute(
                    "author",
                    service.findById(
                            Integer.parseInt(
                                    request.getParameter("id")
                            )
                    )
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/admin/author-form.jsp"
            ).forward(request, response);

            return;
        }

        if ("add".equals(action)) {

            request.getRequestDispatcher(
                    "/WEB-INF/views/admin/author-form.jsp"
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
                "authors",
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
                "/WEB-INF/views/admin/authors.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");

        String id =
                request.getParameter("authorId");

        Author_22133037 author =
                new Author_22133037();

        if (id != null &&
                !id.isEmpty()) {

            author.setAuthorId(
                    Integer.parseInt(id)
            );
        }

        author.setAuthorName(
                request.getParameter(
                        "authorName"
                )
        );

        String date =
                request.getParameter(
                        "dateOfBirth"
                );

        if (date != null &&
                !date.isEmpty()) {

            author.setDateOfBirth(
                    LocalDate.parse(date)
            );
        }

        if (id == null ||
                id.isEmpty()) {

            service.save(author);

        } else {

            service.update(author);
        }

        response.sendRedirect(
                request.getContextPath()
                + "/admin/authors"
        );
    }
}