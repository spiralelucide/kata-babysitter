package data;

import model.Hour;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FamilyATest {

    private Map<Hour, Integer> rates;
    private List<Hour> hoursThatPay15;
    private List<Hour> hoursThatPay20;

    @Before
    public void setUp() {
        Family familyA = new FamilyA();
        rates = familyA.getRates();
        generatePricePerHourLists();
    }

    private void generatePricePerHourLists() {
        hoursThatPay15 = new ArrayList<>(Arrays.asList(SchedulableHours.Five.getHour(),
                                                        SchedulableHours.Six.getHour(),
                                                        SchedulableHours.Seven.getHour(),
                                                        SchedulableHours.Eight.getHour(),
                                                        SchedulableHours.Nine.getHour(),
                                                        SchedulableHours.Ten.getHour()));

        hoursThatPay20 = new ArrayList<>(Arrays.asList(SchedulableHours.Eleven.getHour(),
                                                        SchedulableHours.Twelve.getHour(),
                                                        SchedulableHours.One.getHour(),
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
    public void shouldPayFifteenPerHourBeforeEleven() {
        for(Hour hour : hoursThatPay15) {
            assertEquals("15", rates.get(hour).toString());
        }
    }

    @Test
    public void shouldPayTwentyForRestOfNight() {
        for(Hour hour : hoursThatPay20) {
            assertEquals("20", rates.get(hour).toString());
        }
    }

}