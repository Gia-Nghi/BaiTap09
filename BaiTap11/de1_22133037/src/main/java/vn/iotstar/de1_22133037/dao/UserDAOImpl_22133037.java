package vn.iotstar.de1_22133037.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iotstar.de1_22133037.config.JPAConfig_22133037;
import vn.iotstar.de1_22133037.entity.User_22133037;

public class UserDAOImpl_22133037
        implements UserDAO_22133037 {

    @Override
    public User_22133037 login(
            String email,
            String password) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        try {

            return em.createQuery(
                    "SELECT u FROM User_22133037 u " +
                    "WHERE u.email = :email " +
                    "AND u.passwd = :password",
                    User_22133037.class
            )
            .setParameter("email", email)
            .setParameter("password", password)
            .getResultStream()
            .findFirst()
            .orElse(null);

        } finally {
            em.close();
        }
    }

    @Override
    public User_22133037 findByEmail(
            String email) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        try {

            return em.createQuery(
                    "SELECT u FROM User_22133037 u " +
                    "WHERE u.email = :email",
                    User_22133037.class
            )
            .setParameter("email", email)
            .getResultStream()
            .findFirst()
            .orElse(null);

        } finally {
            em.close();
        }
    }

    @Override
    public User_22133037 save(
            User_22133037 user) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        EntityTransaction tx =
                em.getTransaction();

        try {

            tx.begin();

            em.persist(user);

            tx.commit();

            return user;

        } catch (Exception e) {

            if (tx.isActive())
                tx.rollback();

            throw e;

        } finally {
            em.close();
        }
    }

    @Override
    public void update(
            User_22133037 user) {

        EntityManager em =
                JPAConfig_22133037.getEntityManager();

        EntityTransaction tx =
                em.getTransaction();

        try {

            tx.begin();

            em.merge(user);

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