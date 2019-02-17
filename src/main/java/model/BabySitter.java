package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BabySitter {
    private List<Hour> workHours;

    public BabySitter() {
        workHours = new ArrayList<>();
        Arrays.stream(WorkHours.values()).forEach(hour -> workHours.add(hour.getHour()));
    }

    public List<Hour> getWorkHours() {
        return workHours;
    }

}
