package vn.iotstar.de1_22133037.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rating")
@IdClass(RatingId_22133037.class)
public class Rating_22133037 {

    @Id
    @Column(name = "userid")
    private Integer userid;

    @Id
    @Column(name = "bookid")
    private Integer bookid;

    private Integer rating;

    @Column(name = "review_text")
    private String reviewText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "userid",
            insertable = false,
            updatable = false
    )
    private User_22133037 user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "bookid",
            insertable = false,
            updatable = false
    )
    private Book_22133037 book;

    public Rating_22133037() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public User_22133037 getUser() {
        return user;
    }

    public Book_22133037 getBook() {
        return book;
    }
}