package model;

import data.Family;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkNight {
    private WorkHour startTime;
    private WorkHour endTime;
    private Family family;

    public static boolean isStartTimeBeforeEndTime(WorkHour startTime, WorkHour endTime) {
        return startTime.isBefore(endTime);
    }

    public int calculateTotal() {

        return 0;
    }
}
