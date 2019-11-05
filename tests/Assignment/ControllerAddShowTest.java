package Assignment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Assignment.Main.shows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ControllerAddShowTest {

    @BeforeEach
    public void setUp() throws Exception {

    }

    @AfterEach
    public void tearDown() throws Exception {
    }

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