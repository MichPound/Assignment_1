package Assignment;

import Lists.CustomList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Assignment.Main.shows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

class ControllerAddBookingTest {

    @BeforeEach
    void setUp() {
        shows.addItem(new Show("test",
                "12/11/2019",
                "19/11/2019",
                60,
                12.0,
                13.0,
                14.0));

        shows.get2(0).addPerformance(new Performance("perTest",
                "12/11/2019",
                "Evening"));
    }

    @Test
    void addBooking() {
        CustomList<String> seatList = new CustomList<>();
        seatList.addItem("B1");
        seatList.addItem("B2");
        seatList.addItem("B3");

        shows.get2(0).getPerformances().get2(0).addBooking(new Booking("Michael", "2ca7738c-06ee-47c1-b442-8c841de36ba3", seatList));
        assertSame("Michael", shows.get2(0).getPerformances().get2(0).getBooking().get2(0).getName());
        assertSame("2ca7738c-06ee-47c1-b442-8c841de36ba3", shows.get2(0).getPerformances().get2(0).getBooking().get2(0).getId());
        assertSame("B3", shows.get2(0).getPerformances().get2(0).getBooking().get2(0).getSeatPlan().get2(0));
        assertSame("B1", shows.get2(0).getPerformances().get2(0).getBooking().get2(0).getSeatPlan().get2(2));
        assertFalse(shows.get2(0).getPerformances().get2(0).getBooking().get2(0).getSeatPlan().get2(0).equalsIgnoreCase("B1"));
    }
}