package vn.iotstar.de1_22133037.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iotstar.de1_22133037.config.JPAConfig_22133037;
import vn.iotstar.de1_22133037.entity.Author_22133037;

import java.util.List;

public class AuthorDAOImpl_22133037
        implements AuthorDAO_22133037 {

    @Override
    public List<Author_22133037> findAll(int page, int size) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT a FROM Author_22133037 a " +
                    "ORDER BY a.authorId DESC",
                    Author_22133037.class
            )
            .setFirstResult((page - 1) * size)
            .setMaxResults(size)
            .getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public long count() {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT COUNT(a) FROM Author_22133037 a",
                    Long.class
            ).getSingleResult();

        } finally {
            em.close();
        }
    }

    @Override
    public Author_22133037 findById(Integer id) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        try {
            return em.find(
                    Author_22133037.class,
                    id
            );

        } finally {
            em.close();
        }
    }

    @Override
    public Author_22133037 save(
            Author_22133037 author) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            em.persist(author);

            tx.commit();

            return author;

        } catch (Exception e) {

            if (tx.isActive())
                tx.rollback();

            throw e;

        } finally {
            em.close();
        }
    }

    @Override
    public Author_22133037 update(
            Author_22133037 author) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Author_22133037 result =
                    em.merge(author);

            tx.commit();

            return result;

        } catch (Exception e) {

            if (tx.isActive())
                tx.rollback();

            throw e;

        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Integer id) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Author_22133037 author =
                    em.find(
                            Author_22133037.class,
                            id
                    );

            if (author != null)
                em.remove(author);

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