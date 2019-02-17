package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkHour extends Hour {
    public static final String LOCAL_TIME_PATTERN = "\\d{1,2}:\\d{2}(am|pm)";

    public WorkHour(String time) {
        if(!extractHour(time)){
            throw new IllegalArgumentException("Argument passed to constructor improperly formatted");
        }
    }

    public WorkHour(){}

    private boolean extractHour(String time) {
        if(time.matches(LOCAL_TIME_PATTERN)) {
            String[] split = time.split(":");
            setHour(Integer.valueOf(split[0]));
            setAmPm(split[1].substring(split[1].length()-2));
            return true;
        }
        return false;
    }
}
