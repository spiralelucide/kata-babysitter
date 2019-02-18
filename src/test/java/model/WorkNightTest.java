package model;

import data.FamilyA;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkNightTest {

    private WorkNight workNight;

    @Before
    public void setUp() {
        workNight = new WorkNight();
    }

    @Test
    public void shouldGetStartTime() {
        WorkHour testWorkHour = new WorkHour();
        workNight.setStartTime(testWorkHour);

        assertEquals(testWorkHour, workNight.getStartTime());
    }

    @Test
    public void shouldGetEndTime() {
        WorkHour testWorkHour = new WorkHour();
        workNight.setEndTime(testWorkHour);

        assertEquals(testWorkHour, workNight.getEndTime());
    }

    @Test
    public void shouldGetFamily() {
        workNight.setFamily(new FamilyA());

        assertEquals(new FamilyA(), workNight.getFamily());
    }

    @Test
    public void shouldReturnTrueIfStartTimeIsBeforeEndTime() {
        WorkHour startTime = new WorkHour("4:00am");
        WorkHour endTime = new WorkHour("5:00am");
        boolean result = WorkNight.isStartTimeBeforeEndTime(startTime, endTime);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfStartTimeIsAfterEndTime() {
        WorkHour startTime = new WorkHour("5:00am");
        WorkHour endTime = new WorkHour("4:00am");
        boolean result = WorkNight.isStartTimeBeforeEndTime(startTime, endTime);

        assertFalse(result);
    }

    @Test
    public void shouldReturnZeroDollarsWhenCalculated() {
        int result = workNight.calculateTotal();
        assertEquals(0, result);
    }
}