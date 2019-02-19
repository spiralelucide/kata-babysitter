package com.spiraledlogic.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

    @Test
    public void shouldReturnTrueIfIsValidWorkHour() {
        workHour.setHour(1);
        workHour.setPeriod(Period.am);

        Hour testHour1 = new Hour(1, Period.am);
        Hour testHour2 = new Hour(2, Period.am);
        List<Hour> hours = new ArrayList<>(Arrays.asList(testHour1, testHour2));

        assertTrue(workHour.isValidWorkHour(hours));
    }

    @Test
    public void shouldReturnFalseIfIsNotValidWorkHour() {
        workHour.setHour(3);
        workHour.setPeriod(Period.am);

        Hour testHour1 = new Hour(1, Period.am);
        Hour testHour2 = new Hour(2, Period.am);
        List<Hour> hours = new ArrayList<>(Arrays.asList(testHour1, testHour2));

        assertFalse(workHour.isValidWorkHour(hours));
    }

    @Test
    public void shouldReturnTrueIfIsValidTimeFormat() {
        boolean result = WorkHour.isValidTimeFormat("4:00am");

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfIsNotValidTimeFormat() {
        boolean result = WorkHour.isValidTimeFormat("4:00AM");

        assertFalse(result);
    }
}