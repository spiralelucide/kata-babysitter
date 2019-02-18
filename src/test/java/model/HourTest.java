package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HourTest {

    private Hour hour = new Hour(1, Period.am);

    @Test
    public void getHour() {
        hour.setHour(4);

        assertEquals("4", hour.getHour().toString());
    }

    @Test
    public void shouldGetAmPm() {
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

}
