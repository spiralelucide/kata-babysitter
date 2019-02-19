package com.spiraledlogic.data;

import com.spiraledlogic.model.Hour;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FamilyBTest {

    private Map<Hour, Integer> rates;
    private List<Hour> hoursThatPayTwelve;
    private List<Hour> hoursThatPayEight;
    private List<Hour> hoursThatPaySixteen;

    @Before
    public void setUp() {
        Family familyB = new FamilyB();
        rates = familyB.getRates();
        generatePricePerHourLists();
    }

    private void generatePricePerHourLists() {
        hoursThatPayTwelve = new ArrayList<>(Arrays.asList(SchedulableHours.Five.getHour(),
                                                            SchedulableHours.Six.getHour(),
                                                            SchedulableHours.Seven.getHour(),
                                                            SchedulableHours.Eight.getHour(),
                                                            SchedulableHours.Nine.getHour()));

        hoursThatPayEight = new ArrayList<>(Arrays.asList(SchedulableHours.Ten.getHour(),
                                                            SchedulableHours.Eleven.getHour(),
                                                            SchedulableHours.Twelve.getHour()));

        hoursThatPaySixteen = new ArrayList<>(Arrays.asList(SchedulableHours.One.getHour(),
                                                            SchedulableHours.Two.getHour(),
                                                            SchedulableHours.Three.getHour(),
                                                            SchedulableHours.Four.getHour()));
    }

    @Test
    public void shouldGetRates() {
        assertNotNull(rates);
        assertEquals(12, rates.size());
    }

    @Test
    public void shouldPayTwelvePerHourBeforeTen() {
        for(Hour hour : hoursThatPayTwelve) {
            assertEquals("12", rates.get(hour).toString());
        }
    }

    @Test
    public void shouldPayEightPerHourBetweenTenAndTwelve() {
        for(Hour hour : hoursThatPayEight) {
            assertEquals("8", rates.get(hour).toString());
        }
    }

    @Test
    public void shouldPaySixteenPerHourForRestOfNight() {
        for(Hour hour : hoursThatPaySixteen) {
            assertEquals("16", rates.get(hour).toString());
        }
    }

}