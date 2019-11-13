package Assignment;


import Lists.CustomList;

public class Booking {
    private String name, id;
    private int sType;
    private CustomList<String> seatPlan;

    public Booking(String name, String id, int sType, CustomList<String> seatPlan) {
        this.name = name;
        this.id = id;
        this.sType = sType;
        this.seatPlan = seatPlan;
    }
//    public Booking(String name, String id, int seats, int sType, double bookingCost, CustomList<String> seatPlan) {
//        this.name = name;
//        this.id = id;
//        this.seats = seats;
//        this.sType = sType;
//        this.bookingCost = bookingCost;
//        this.seatPlan = seatPlan;
//    }

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

    public int getsType() {
        return sType;
    }

    public void setsType(int sType) {
        this.sType = sType;
    }

    public CustomList<String> getSeatPlan() {
        return seatPlan;
    }

    public void setSeatPlan(CustomList<String> seatPlan) {
        this.seatPlan = seatPlan;
    }

}
