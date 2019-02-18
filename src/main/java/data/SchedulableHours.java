package data;

import lombok.Getter;
import model.Hour;
import model.Period;

@Getter
public enum SchedulableHours {
    Five(new Hour(5, Period.pm)),
    Six(new Hour(6, Period.pm)),
    Seven(new Hour(7, Period.pm)),
    Eight(new Hour(8, Period.pm)),
    Nine(new Hour(9, Period.pm)),
    Ten(new Hour(10, Period.pm)),
    Eleven(new Hour(11, Period.pm)),
    Twelve(new Hour(12, Period.am)),
    One(new Hour(1, Period.am)),
    Two(new Hour(2, Period.am)),
    Three(new Hour(3, Period.am)),
    Four(new Hour(4, Period.am));

    private final Hour hour;

    SchedulableHours(Hour hour) {
        this.hour = hour;
    }
}
