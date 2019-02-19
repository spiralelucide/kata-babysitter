package com.spiraledlogic.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HourTest {

    private Hour hour = new Hour(1, Period.am);

    @Test
    public void shouldGetHour() {
        hour.setHour(4);

        assertEquals("4", hour.getHour().toString());
    }

    @Test
    public void shouldGetPeriod() {
        hour.setPeriod(Period.am);

        assertEquals("am", hour.getPeriod().toString());
    }

    @Test
    public void shouldDeterminePmIsBeforeAm() {
        boolean result = hour.isBefore(new Hour(7, Period.pm));
        assertFalse(result);
    }

    @Test
    public void shouldDetermineEarlierHourAsBeforeLaterHour() {
        boolean result = hour.isBefore(new Hour(3, Period.am));
        assertTrue(result);
    }

    @Test
    public void shouldOrderTwelveAmBeforeOneAm() {
        boolean result = hour.isBefore(new Hour(12,Period.am));
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenEvaluatingTheSameHourIsBefore() {
        boolean result = hour.isBefore(new Hour(1,Period.am));
        assertFalse(result);
    }

}
