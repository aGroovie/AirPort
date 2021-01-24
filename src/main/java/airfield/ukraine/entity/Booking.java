package airfield.ukraine.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Booking {

    private Long bookingId;

    private float price;

    private String issueTime;

    private Long sellerId;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return Float.compare(booking.price, price) == 0 &&
                Objects.equals(bookingId, booking.bookingId) &&
                Objects.equals(issueTime, booking.issueTime) &&
                Objects.equals(sellerId, booking.sellerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, price, issueTime, sellerId);
    }
}
