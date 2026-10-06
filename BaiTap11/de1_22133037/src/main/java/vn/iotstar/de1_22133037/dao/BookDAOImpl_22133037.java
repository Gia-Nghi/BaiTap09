package vn.iotstar.de1_22133037.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iotstar.de1_22133037.config.JPAConfig_22133037;
import vn.iotstar.de1_22133037.entity.Book_22133037;

import java.util.List;

public class BookDAOImpl_22133037 implements BookDAO_22133037 {

    @Override
    public List<Book_22133037> findAll(int page, int size) {

        EntityManager em = JPAConfig_22133037.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT DISTINCT b FROM Book_22133037 b " +
                    "LEFT JOIN FETCH b.authors " +
                    "ORDER BY b.bookid DESC",
                    Book_22133037.class)
                    .setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public long count() {

        EntityManager em = JPAConfig_22133037.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT COUNT(b) FROM Book_22133037 b",
                    Long.class
            ).getSingleResult();

        } finally {
            em.close();
        }
    }

    @Override
    public Book_22133037 findById(Integer id) {

        EntityManager em = JPAConfig_22133037.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT DISTINCT b FROM Book_22133037 b " +
                    "LEFT JOIN FETCH b.authors " +
                    "WHERE b.bookid = :id",
                    Book_22133037.class
            )
            .setParameter("id", id)
            .getSingleResult();

        } finally {
            em.close();
        }
    }

    @Override
    public Book_22133037 save(Book_22133037 book) {

        EntityManager em = JPAConfig_22133037.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(book);
            tx.commit();

            return book;

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            throw e;

        } finally {
            em.close();
        }
    }

    @Override
    public Book_22133037 update(Book_22133037 book) {

        EntityManager em = JPAConfig_22133037.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Book_22133037 result = em.merge(book);

            tx.commit();

            return result;

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            throw e;

        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Integer id) {

        EntityManager em = JPAConfig_22133037.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Book_22133037 book = em.find(
                    Book_22133037.class,
                    id
            );

            if (book != null) {
                em.remove(book);
            }

            tx.commit();

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            throw e;

        } finally {
            em.close();
        }
    }
}