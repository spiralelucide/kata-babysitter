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
    public void shouldCreateWorkHourWithFormattedString() {
        new WorkHour("12:00am");
    }

    @Test
    public void shouldThrowExceptionWhenConstructorFedBadTime() {
        try {
            new WorkHour("this is junk");
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Argument passed to constructor improperly formatted"));
        }
    }

}