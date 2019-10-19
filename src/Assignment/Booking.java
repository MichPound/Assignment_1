package Assignment;


public class Booking {
    private String name;
    private int seats, sType;

    public Booking(String name, int seats, int sType) {
        this.name = name;
        this.seats = seats;
        this.sType = sType;
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
}
