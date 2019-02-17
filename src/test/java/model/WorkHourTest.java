package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkHourTest {

    private WorkHour workHour;

    @Before
    public void setUp() {
        this.workHour = new WorkHour();
    }
    @Test
    public void getHour() {
        Hour testHour = new Hour(12);
        workHour.setHour(testHour);

        assertEquals(testHour, workHour.getHour());
    }
}