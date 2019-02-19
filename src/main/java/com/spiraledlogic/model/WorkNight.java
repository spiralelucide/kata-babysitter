package com.spiraledlogic.model;

import com.spiraledlogic.data.Family;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WorkNight {
    private WorkHour startTime;
    private WorkHour endTime;
    private Family family;

    public static boolean isStartTimeBeforeEndTime(WorkHour startTime, WorkHour endTime) {
        return startTime.isBefore(endTime);
    }

    public Integer calculateTotal() {
        return calculate(false, new ArrayList<>(family.getRates().keySet()));
    }

    private Integer calculate(boolean isAdding, List<Hour> hours) {
        if(hours.get(0).equals(endTime)) {
            return 0;
        }
        if(hours.get(0).equals(startTime)) {
            isAdding = true;
        }
        Integer cal = calculate(isAdding, hours.subList(1, hours.size()));
        if(isAdding) {
            return cal + family.getRates().get(hours.get(0));
        }
        return cal;
    }
}
