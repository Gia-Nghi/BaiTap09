package vn.iotstar.de1_22133037.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iotstar.de1_22133037.entity.Rating_22133037;
import vn.iotstar.de1_22133037.entity.User_22133037;
import vn.iotstar.de1_22133037.service.RatingService_22133037;

import java.io.IOException;

@WebServlet("/review")
public class ReviewController_22133037
        extends HttpServlet {

    private final RatingService_22133037 service =
            new RatingService_22133037();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session =
                request.getSession(false);

        User_22133037 user = null;

        if (session != null) {

            user =
                    (User_22133037)
                            session.getAttribute(
                                    "currentUser"
                            );
        }

        if (user == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/login"
            );

            return;
        }

        Integer bookId =
                Integer.parseInt(
                        request.getParameter(
                                "bookid"
                        )
                );

        Integer rating =
                Integer.parseInt(
                        request.getParameter(
                                "rating"
                        )
                );

        String reviewText =
                request.getParameter(
                        "reviewText"
                );

        Rating_22133037 review =
                new Rating_22133037();

        review.setUserid(
                user.getId()
        );

        review.setBookid(
                bookId
        );

        review.setRating(
                rating
        );

        review.setReviewText(
                reviewText
        );

        service.save(review);

        response.sendRedirect(
                request.getContextPath()
                + "/book-detail?id="
                + bookId
        );
    }
}