package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Hour {
    private Integer hour;
    private String amPm;

    public Hour(){}

    public Hour(Integer hour, String amPm) {
        this.hour = hour;
        this.amPm = amPm;
    }

    @Override
    public String toString() {
        return String.format("%s:00%s",hour.toString(),amPm);
    }

}
