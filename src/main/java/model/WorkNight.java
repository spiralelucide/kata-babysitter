package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkNight {
    private WorkHour startTime;
    private WorkHour endTime;
    private String family;
}
