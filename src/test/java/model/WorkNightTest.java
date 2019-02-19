package model;

import data.FamilyA;
import data.FamilyC;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void shouldReturnFifteenDollarsWhenCalculated() {
        workNight.setStartTime(new WorkHour("5:00pm"));
        workNight.setEndTime(new WorkHour("6:00pm"));
        workNight.setFamily(new FamilyA());

        int result = workNight.calculateTotal();

        assertEquals(15, result);
    }

    @Test
    public void shouldReturnThirtyDollarsWhenCalculated() {
        workNight.setStartTime(new WorkHour("5:00pm"));
        workNight.setEndTime(new WorkHour("7:00pm"));
        workNight.setFamily(new FamilyA());
        int result = workNight.calculateTotal();
        assertEquals(30, result);
    }

    @Test
    public void shouldCalculateOverPayTransitions() {
        workNight.setStartTime(new WorkHour("5:00pm"));
        workNight.setEndTime(new WorkHour("4:00am"));
        workNight.setFamily(new FamilyC());

        int result = workNight.calculateTotal();
        assertEquals(189, result);
    }
}