package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class HourTest {

    private Hour hour = new Hour(12, "am");

    @Test
    public void getHour() {
        hour.setHour(4);

        assertEquals("4", hour.getHour().toString());
    }

    @Test
    public void shouldGetAmPm() {
        hour.setAmPm("am");

        assertEquals("am", hour.getAmPm());
    }
}