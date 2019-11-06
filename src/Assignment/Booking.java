package Assignment;


import Lists.CustomList;

public class Booking {
    private String name;
    private int seats, sType;
    private double bookingCost;
    private CustomList<String> seatPlan;

    public Booking(String name, int seats, int sType,double bookingCost, CustomList<String> seatPlan) {
        this.name = name;
        this.seats = seats;
        this.sType = sType;
        this.bookingCost = bookingCost;
        this.seatPlan = seatPlan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getsType() {
        return sType;
    }

    public void setsType(int sType) {
        this.sType = sType;
    }

    public double getBookingCost() {
        return bookingCost;
    }

    public void setBookingCost(double bookingCost) {
        this.bookingCost = bookingCost;
    }

    public CustomList<String> getSeatPlan() {
        return seatPlan;
    }

    public void setSeatPlan(CustomList<String> seatPlan) {
        this.seatPlan = seatPlan;
    }

}
