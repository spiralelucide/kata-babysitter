package com.spiraledlogic.model;

import com.spiraledlogic.data.Family;
import com.spiraledlogic.data.FamilyA;
import com.spiraledlogic.data.FamilyB;
import com.spiraledlogic.data.FamilyC;
import com.spiraledlogic.data.SchedulableHours;
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
