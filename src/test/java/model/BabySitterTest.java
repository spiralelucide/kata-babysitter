package model;

import data.FamilyA;
import data.FamilyB;
import data.FamilyC;
import data.SchedulableHours;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BabySitterTest {

    @Test
    public void shouldConstructDefaultBabySitterHours() {
        BabySitter babySitter = new BabySitter();

        assertEquals(12, babySitter.getWorkHours().size());
        assertTrue(Arrays.stream(SchedulableHours.values()).allMatch(schedulableHours -> babySitter.getWorkHours().contains(schedulableHours.getHour())));
    }

    @Test
    public void shouldConstructDefaultBabySitterFamilies() {
        BabySitter babySitter = new BabySitter();

        assertEquals(3, babySitter.getFamilies().size());
        assertEquals(new FamilyA(), babySitter.getFamilies().get(FamilyA.NAME));
        assertEquals(new FamilyB(), babySitter.getFamilies().get(FamilyB.NAME));
        assertEquals(new FamilyC(), babySitter.getFamilies().get(FamilyC.NAME));
    }
}