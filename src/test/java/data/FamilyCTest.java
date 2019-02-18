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

public class FamilyCTest {

    private Map<Hour, Integer> rates;
    private List<Hour> hoursThatPayTwentyOne;
    private List<Hour> hoursThatPayFifteen;

    @Before
    public void setUp() {
        Family familyC = new FamilyC();
        rates = familyC.getRates();
        generatePricePerHourLists();
    }

    private void generatePricePerHourLists() {
        hoursThatPayTwentyOne = new ArrayList<>(Arrays.asList(SchedulableHours.Five.getHour(),
                                                                SchedulableHours.Six.getHour(),
                                                                SchedulableHours.Seven.getHour(),
                                                                SchedulableHours.Eight.getHour()));

        hoursThatPayFifteen = new ArrayList<>(Arrays.asList(SchedulableHours.Nine.getHour(),
                                                            SchedulableHours.Ten.getHour(),
                                                            SchedulableHours.Eleven.getHour(),
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
    public void shouldPayTwentyOnePerHourBeforeNine() {
        for(Hour hour : hoursThatPayTwentyOne) {
            assertEquals("21", rates.get(hour).toString());
        }
    }

    @Test
    public void shouldPayFifteenForRestOfNight() {
        for(Hour hour : hoursThatPayFifteen) {
            assertEquals("15", rates.get(hour).toString());
        }
    }

}