package vn.iotstar.de1_22133037.entity;


import java.math.BigDecimal;

public class CartItem_22133037 {

    private Book_22133037 book;
    private int quantity;

    public CartItem_22133037() {
    }

    public CartItem_22133037(Book_22133037 book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book_22133037 getBook() {
        return book;
    }

    public void setBook(Book_22133037 book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return book.getPrice()
                .multiply(BigDecimal.valueOf(quantity));
    }
}