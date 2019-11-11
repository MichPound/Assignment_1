package Assignment;


import Lists.CustomList;

public class Booking {
    private String name, id;
    private int seats, sType;
    private double bookingCost;
    private CustomList<String> seatPlan;

    public Booking(String name, String id, int seats, int sType, double bookingCost, CustomList<String> seatPlan) {
        this.name = name;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
