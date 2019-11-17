package Assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Assignment.Main.shows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControllerCancelShowTest {

    @BeforeEach
    void setUp() {
        shows.addItem(new Show("test",
                "12/11/2019",
                "19/11/2019",
                60,
                12.0,
                13.0,
                14.0));
    }

    @Test
    void removingShow() {
        assertTrue(shows.getSize() != 0);
        shows.remove(0);
        assertEquals(0, shows.getSize());
    }
}