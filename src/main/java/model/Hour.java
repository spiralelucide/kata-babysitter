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

    public boolean isBefore(Hour h1) {
        if(this.period != h1.period) {
            return this.period.equals(Period.pm);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s:00%s",hour.toString(), period);
    }

//    @Override
//    public int compareTo(Hour o) {
//        int lastCmp = period.compareTo(o.period);
//        return (lastCmp == 0 ? lastCmp : hour.compareTo(o.hour));
//    }


}
