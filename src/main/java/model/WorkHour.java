package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkHour {
    public static final String LOCAL_TIME_PATTERN = "\\d{1,2}:\\d{2}(am|pm)";

    private Hour hour;
}
