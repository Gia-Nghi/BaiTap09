package vn.iotstar.de1_22133037.service;

import vn.iotstar.de1_22133037.dao.RatingDAO_22133037;
import vn.iotstar.de1_22133037.entity.Rating_22133037;

import java.util.List;

public class RatingService_22133037 {

    private final RatingDAO_22133037 dao =
            new RatingDAO_22133037();

    public List<Rating_22133037> findByBook(
            Integer bookId) {

        return dao.findByBook(bookId);
    }

    public double getAverageRating(
            Integer bookId) {

        return dao.getAverageRating(bookId);
    }

    public long countByBook(
            Integer bookId) {

        return dao.countByBook(bookId);
    }

    public void save(
            Rating_22133037 rating) {

        dao.save(rating);
    }
}