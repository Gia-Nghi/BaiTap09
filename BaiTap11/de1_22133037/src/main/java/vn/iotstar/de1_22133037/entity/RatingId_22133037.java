package vn.iotstar.de1_22133037.entity;

import java.io.Serializable;
import java.util.Objects;

public class RatingId_22133037 implements Serializable {

    private Integer userid;
    private Integer bookid;

    public RatingId_22133037() {
    }

    public RatingId_22133037(Integer userid, Integer bookid) {
        this.userid = userid;
        this.bookid = bookid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof RatingId_22133037)) return false;

        RatingId_22133037 that = (RatingId_22133037) o;

        return Objects.equals(userid, that.userid)
                && Objects.equals(bookid, that.bookid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, bookid);
    }
}