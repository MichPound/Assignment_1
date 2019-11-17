package Assignment;

import org.junit.jupiter.api.Test;

import static Assignment.Main.shows;
import static org.junit.jupiter.api.Assertions.assertSame;

class ControllerAddShowTest {

    @Test
    void add() {
        shows.addItem(new Show("test",
                "12/11/2019",
                "19/11/2019",
                60,
                12.0,
                13.0,
                14.0));
        assertSame("test", shows.get2(0).getTitle());
        assertSame("12/11/2019", shows.get2(0).getsDate());
        assertSame("19/11/2019", shows.get2(0).geteDate());
        assertSame(60, shows.get2(0).getTime());
    }
}