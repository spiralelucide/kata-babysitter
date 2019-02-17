package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Hour {
    private Integer hour;

    public Hour(Integer hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return hour.toString();
    }
}
