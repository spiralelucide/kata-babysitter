package com.spiraledlogic.model;

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
        } else if(this.hour.equals(12) || h1.hour.equals(12)) {
            return this.hour.equals(12);
        } else if(!this.hour.equals(h1.hour)) {
            return this.hour.compareTo(h1.hour) < 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s:00%s",hour.toString(), period);
    }

}
