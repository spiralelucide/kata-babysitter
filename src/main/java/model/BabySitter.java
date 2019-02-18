package model;

import data.Family;
import data.FamilyA;
import data.FamilyB;
import data.FamilyC;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class BabySitter {
    private List<Hour> workHours;
    private Map<String,Family> families;

    public BabySitter() {
        workHours = new ArrayList<>();
        Arrays.stream(SchedulableHours.values()).forEach(hour -> workHours.add(hour.getHour()));

        families = new HashMap<>();
        families.put(FamilyA.NAME, new FamilyA());
        families.put(FamilyB.NAME, new FamilyB());
        families.put(FamilyC.NAME, new FamilyC());
    }

}
