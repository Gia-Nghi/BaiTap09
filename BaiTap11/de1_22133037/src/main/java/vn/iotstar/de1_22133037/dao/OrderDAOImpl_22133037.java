package vn.iotstar.de1_22133037.dao;


import vn.iotstar.de1_22133037.entity.Order_22133037;
import jakarta.persistence.EntityManager;
import vn.iotstar.de1_22133037.config.JPAConfig_22133037;

import java.util.List;

public class OrderDAOImpl_22133037
        implements OrderDAO_22133037 {

    @Override
    public List<Order_22133037> findByUserId(
            int userId) {

        EntityManager em =
                JPAConfig_22133037
                        .getEntityManager();

        try {

            return em.createQuery(
                    "SELECT o " +
                    "FROM Order_22133037 o " +
                    "WHERE o.user.id = :userId " +
                    "ORDER BY o.orderDate DESC",
                    Order_22133037.class
            )
            .setParameter(
                    "userId",
                    userId
            )
            .getResultList();

        } finally {

            em.close();
        }
    }

    @Override
    public List<Order_22133037>
    findByUserIdAndStatus(
            int userId,
            String status) {

        EntityManager em =
                JPAConfig_22133037
                        .getEntityManager();

        try {

            return em.createQuery(
                    "SELECT o " +
                    "FROM Order_22133037 o " +
                    "WHERE o.user.id = :userId " +
                    "AND o.status = :status " +
                    "ORDER BY o.orderDate DESC",
                    Order_22133037.class
            )
            .setParameter(
                    "userId",
                    userId
            )
            .setParameter(
                    "status",
                    status
            )
            .getResultList();

        } finally {

            em.close();
        }
    }
}