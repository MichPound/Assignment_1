package Assignment;

import Lists.CustomList;

public class Performance {
    private String title, date, time;
    private CustomList<Booking> bookings = new CustomList<>();

    //Constructor for Performance class
    public Performance(String title, String date, String time) {
        this.title = title;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void addBooking(Booking booking) {
        this.bookings.addItem(booking);
    }

    public CustomList<Booking> getBooking() {
        return bookings;
    }
}
