package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Hour {
    private Integer hour;
    private Period period;

    public Hour(){}

    public Hour(Integer hour, Period period) {
        this.hour = hour;
        this.period = period;
    }

    @Override
    public String toString() {
        return String.format("%s:00%s",hour.toString(), period);
    }

}
