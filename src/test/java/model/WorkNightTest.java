package model;

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
    public void getStartTime() {
        WorkHour testWorkHour = new WorkHour();
        workNight.setStartTime(testWorkHour);

        assertEquals(testWorkHour, workNight.getStartTime());
    }

    @Test
    public void getEndTime() {
        WorkHour testWorkHour = new WorkHour();
        workNight.setEndTime(testWorkHour);

        assertEquals(testWorkHour, workNight.getEndTime());
    }

    @Test
    public void getFamily() {
        workNight.setFamily("Family");

        assertEquals("Family", workNight.getFamily());
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
}