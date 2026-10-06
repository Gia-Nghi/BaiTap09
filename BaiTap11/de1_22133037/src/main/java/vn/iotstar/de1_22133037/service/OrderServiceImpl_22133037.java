package vn.iotstar.de1_22133037.service;

import vn.iotstar.de1_22133037.dao.OrderDAO_22133037;
import vn.iotstar.de1_22133037.dao.OrderDAOImpl_22133037;
import vn.iotstar.de1_22133037.entity.Book_22133037;
import vn.iotstar.de1_22133037.entity.CartItem_22133037;
import vn.iotstar.de1_22133037.entity.OrderDetail_22133037;
import vn.iotstar.de1_22133037.entity.Order_22133037;
import vn.iotstar.de1_22133037.entity.User_22133037;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iotstar.de1_22133037.config.JPAConfig_22133037;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl_22133037
        implements OrderService_22133037 {

    private OrderDAO_22133037 orderDAO =
            new OrderDAOImpl_22133037();

    @Override
    public boolean createOrder(
            int userId,
            String receiverName,
            String receiverPhone,
            String shippingAddress,
            Map<Integer, CartItem_22133037> cart) {

        EntityManager em =
                JPAConfig_22133037
                        .getEntityManager();

        EntityTransaction transaction =
                em.getTransaction();

        try {

            transaction.begin();

            User_22133037 user =
                    em.find(
                            User_22133037.class,
                            userId
                    );

            if (user == null) {
                transaction.rollback();
                return false;
            }

            Order_22133037 order =
                    new Order_22133037();

            order.setUser(user);

            order.setOrderDate(
                    new Date()
            );

            order.setReceiverName(
                    receiverName
            );

            order.setReceiverPhone(
                    receiverPhone
            );

            order.setShippingAddress(
                    shippingAddress
            );

            order.setPaymentMethod(
                    "COD"
            );

            order.setStatus(
                    "NEW"
            );

            BigDecimal total =
                    BigDecimal.ZERO;

            for (CartItem_22133037 item
                    : cart.values()) {

                Book_22133037 book =
                        em.find(
                                Book_22133037.class,
                                item.getBook()
                                        .getBookid()
                        );

                if (book == null) {

                    transaction.rollback();
                    return false;
                }

                int currentQuantity =
                        book.getQuantity();

                int orderedQuantity =
                        item.getQuantity();

                if (currentQuantity
                        < orderedQuantity) {

                    transaction.rollback();
                    return false;
                }

                BigDecimal price =
                        book.getPrice();

                BigDecimal subtotal =
                        price.multiply(
                                BigDecimal.valueOf(
                                        orderedQuantity
                                )
                        );

                OrderDetail_22133037 detail =
                        new OrderDetail_22133037();

                detail.setOrder(order);

                detail.setBook(book);

                detail.setQuantity(
                        orderedQuantity
                );

                detail.setPrice(
                        price
                );

                detail.setSubtotal(
                        subtotal
                );

                order.getOrderDetails()
                        .add(detail);

                book.setQuantity(
                        currentQuantity
                        - orderedQuantity
                );

                total =
                        total.add(subtotal);
            }

            order.setTotalAmount(total);

            em.persist(order);

            transaction.commit();

            return true;

        } catch (Exception e) {

            if (transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();

            return false;

        } finally {

            em.close();
        }
    }

    @Override
    public List<Order_22133037>
    findByUserId(int userId) {

        return orderDAO.findByUserId(
                userId
        );
    }

    @Override
    public List<Order_22133037>
    findByUserIdAndStatus(
            int userId,
            String status) {

        return orderDAO.findByUserIdAndStatus(
                userId,
                status
        );
    }
}
