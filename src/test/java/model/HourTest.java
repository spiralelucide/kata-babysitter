package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class HourTest {

    private Hour hour = new Hour(12, Period.am);

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
}