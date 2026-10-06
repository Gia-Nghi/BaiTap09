package vn.iotstar.de1_22133037.service;


import vn.iotstar.de1_22133037.entity.CartItem_22133037;
import vn.iotstar.de1_22133037.entity.Order_22133037;

import java.util.List;
import java.util.Map;

public interface OrderService_22133037 {

    boolean createOrder(
            int userId,
            String receiverName,
            String receiverPhone,
            String shippingAddress,
            Map<Integer, CartItem_22133037> cart
    );

    List<Order_22133037> findByUserId(
            int userId
    );

    List<Order_22133037> findByUserIdAndStatus(
            int userId,
            String status
    );
}