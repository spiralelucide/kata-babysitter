package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkNight {
    private WorkHour startTime;
    private WorkHour endTime;
    private String family;

    public static boolean isStartTimeBeforeEndTime(WorkHour startTime, WorkHour endTime) {
        return startTime.isBefore(endTime);
    }
}
