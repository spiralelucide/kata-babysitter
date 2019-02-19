package com.spiraledlogic.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class SchedulableHoursTest {

    @Test
    public void shouldGetHour() {
        SchedulableHours hour = SchedulableHours.Four;

        assertEquals("4:00am", hour.getHour().toString());
    }
}
