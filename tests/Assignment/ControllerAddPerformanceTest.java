package Assignment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Assignment.Main.shows;
import static org.junit.jupiter.api.Assertions.*;

class ControllerAddPerformanceTest {

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

    @AfterEach
    void tearDown() {
    }

    @Test
    void matinee() {
    }

    @Test
    void evening() {
    }

    @Test
    void addPerformance() {
        shows.get2(0).addPerformance(new Performance("perTest", "12/11/2019", "Evening"));
        assertSame("perTest", shows.get2(0).getPerformances().get2(0).getTitle());
        assertSame("12/11/2019", shows.get2(0).getPerformances().get2(0).getDate());
        assertSame("Evening", shows.get2(0).getPerformances().get2(0).getTime());
    }
}