package com.spiraledlogic.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkHour extends Hour {
    public static final String LOCAL_TIME_PATTERN = "\\d{1,2}:\\d{2}(am|pm)";

    public WorkHour(){}

    public WorkHour(String time) {
        if(!extractHour(time)){
            throw new IllegalArgumentException("Argument passed to constructor improperly formatted");
        }
    }

    public boolean isValidWorkHour(List<Hour> workHours) {
        return workHours.contains(this);
    }

    public static boolean isValidTimeFormat(String time) {
        return time.matches(LOCAL_TIME_PATTERN);
    }

    private boolean extractHour(String time) {
        if(WorkHour.isValidTimeFormat(time)) {
            String[] split = time.split(":");
            setHour(Integer.valueOf(split[0]));
            setPeriod(Period.valueOf(split[1].substring(split[1].length()-2)));
            return true;
        }
        return false;
    }
}
