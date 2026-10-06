package vn.iotstar.de1_22133037.dao;


import vn.iotstar.de1_22133037.entity.Order_22133037;

import java.util.List;

public interface OrderDAO_22133037 {

    List<Order_22133037> findByUserId(
            int userId
    );

    List<Order_22133037> findByUserIdAndStatus(
            int userId,
            String status
    );
}
