package vn.iotstar.de1_22133037.service;


import vn.iotstar.de1_22133037.entity.Book_22133037;
import vn.iotstar.de1_22133037.entity.CartItem_22133037;

import java.util.Map;

public class CartServiceImpl_22133037
        implements CartService_22133037 {

    @Override
    public void addToCart(
            Map<Integer, CartItem_22133037> cart,
            Book_22133037 book) {

        int bookId = book.getBookid();

        if (book.getQuantity() <= 0) {
            return;
        }

        if (cart.containsKey(bookId)) {

            CartItem_22133037 item =
                    cart.get(bookId);

            int newQuantity =
                    item.getQuantity() + 1;

            if (newQuantity <= book.getQuantity()) {
                item.setQuantity(newQuantity);
            }

        } else {

            CartItem_22133037 item =
                    new CartItem_22133037(book, 1);

            cart.put(bookId, item);
        }
    }

    @Override
    public void updateQuantity(
            Map<Integer, CartItem_22133037> cart,
            int bookId,
            int quantity) {

        CartItem_22133037 item =
                cart.get(bookId);

        if (item == null) {
            return;
        }

        if (quantity <= 0) {
            cart.remove(bookId);
            return;
        }

        int maxQuantity =
                item.getBook().getQuantity();

        if (quantity > maxQuantity) {
            quantity = maxQuantity;
        }

        item.setQuantity(quantity);
    }

    @Override
    public void removeFromCart(
            Map<Integer, CartItem_22133037> cart,
            int bookId) {

        cart.remove(bookId);
    }

    @Override
    public void clearCart(
            Map<Integer, CartItem_22133037> cart) {

        cart.clear();
    }
}