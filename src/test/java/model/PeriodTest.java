package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeriodTest {

    @Test
    public void getPeriod() {
        assertEquals("am", Period.am.toString());
        assertEquals("pm", Period.pm.toString());
    }
}