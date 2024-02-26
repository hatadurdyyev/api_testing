package pojos;

public class bookingResponsePojo {
    private Integer bookingid;
    private bookingPojo booking;

    public bookingResponsePojo() {
    }

    public bookingResponsePojo(Integer bookingid, bookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public bookingPojo getBooking() {
        return booking;
    }

    public void setBooking(bookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "bookingResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
