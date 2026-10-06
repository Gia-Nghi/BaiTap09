package vn.iotstar.de1_22133037.dao;

import jakarta.persistence.EntityManager;
import vn.iotstar.de1_22133037.config.JPAConfig_22133037;
import vn.iotstar.de1_22133037.entity.Rating_22133037;

import java.util.List;

public class RatingDAO_22133037 {

    public List<Rating_22133037> findByBook(
            Integer bookId) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        try {

            return em.createQuery(
                    "SELECT r FROM Rating_22133037 r " +
                    "JOIN FETCH r.user " +
                    "WHERE r.bookid = :bookId " +
                    "ORDER BY r.userid DESC",
                    Rating_22133037.class
            )
            .setParameter("bookId", bookId)
            .getResultList();

        } finally {
            em.close();
        }
    }

    public double getAverageRating(
            Integer bookId) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        try {

            Double result = em.createQuery(
                    "SELECT AVG(r.rating) " +
                    "FROM Rating_22133037 r " +
                    "WHERE r.bookid = :bookId",
                    Double.class
            )
            .setParameter("bookId", bookId)
            .getSingleResult();

            return result == null ? 0 : result;

        } finally {
            em.close();
        }
    }

    public long countByBook(Integer bookId) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        try {

            return em.createQuery(
                    "SELECT COUNT(r) " +
                    "FROM Rating_22133037 r " +
                    "WHERE r.bookid = :bookId",
                    Long.class
            )
            .setParameter("bookId", bookId)
            .getSingleResult();

        } finally {
            em.close();
        }
    }

    public void save(Rating_22133037 rating) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        var tx = em.getTransaction();

        try {

            tx.begin();

            Rating_22133037 old =
                    em.find(
                            Rating_22133037.class,
                            new vn.iotstar.de1_22133037.entity.RatingId_22133037(
                                    rating.getUserid(),
                                    rating.getBookid()
                            )
                    );

            if (old == null) {
                em.persist(rating);
            } else {
                old.setRating(rating.getRating());
                old.setReviewText(rating.getReviewText());
            }

            tx.commit();

        } catch (Exception e) {

            if (tx.isActive())
                tx.rollback();

            throw e;

        } finally {
            em.close();
        }
    }
}