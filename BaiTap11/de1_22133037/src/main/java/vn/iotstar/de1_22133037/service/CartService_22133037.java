package vn.iotstar.de1_22133037.service;


import vn.iotstar.de1_22133037.entity.Book_22133037;
import vn.iotstar.de1_22133037.entity.CartItem_22133037;

import java.util.Map;

public interface CartService_22133037 {

    void addToCart(
            Map<Integer, CartItem_22133037> cart,
            Book_22133037 book
    );

    void updateQuantity(
            Map<Integer, CartItem_22133037> cart,
            int bookId,
            int quantity
    );

    void removeFromCart(
            Map<Integer, CartItem_22133037> cart,
            int bookId
    );

    void clearCart(
            Map<Integer, CartItem_22133037> cart
    );
}