package Assignment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Assignment.Main.shows;
import static org.junit.jupiter.api.Assertions.*;

class ControllerCancelPerformanceTest {

    @BeforeEach
    void setUp() {
        shows.addItem(new Show("test",
                "12/11/2019",
                "19/11/2019",
                60,
                12.0,
                13.0,
                14.0));
        shows.get2(0).addPerformance(new Performance("perTest", "12/11/2019", "Evening"));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void cancelPerformance() {
        assertTrue(shows.get2(0).getPerformances().getSize() != 0);
        shows.get2(0).getPerformances().remove(0);
        assertEquals(0, shows.get2(0).getPerformances().getSize());
    }
}