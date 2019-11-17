package Assignment;

import Lists.CustomList;

public class Booking {
    private String name, id;
    private CustomList<String> seatPlan;

    public Booking(String name, String id, CustomList<String> seatPlan) {
        this.name = name;
        this.id = id;
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

    public CustomList<String> getSeatPlan() {
        return seatPlan;
    }

    public void setSeatPlan(CustomList<String> seatPlan) {
        this.seatPlan = seatPlan;
    }

}
