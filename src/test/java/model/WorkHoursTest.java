package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorkHoursTest {

    @Test
    public void shouldGetHour() {
        WorkHours hour = WorkHours.Four;

        assertEquals("4", hour.getHour().toString());
    }
}