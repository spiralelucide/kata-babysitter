package model;

import lombok.Getter;

@Getter
public enum WorkHours {
    Five(new Hour(5, "pm")),
    Six(new Hour(6, "pm")),
    Seven(new Hour(7, "pm")),
    Eight(new Hour(8, "pm")),
    Nine(new Hour(9, "pm")),
    Ten(new Hour(10, "pm")),
    Eleven(new Hour(11, "pm")),
    Twelve(new Hour(12, "am")),
    One(new Hour(1, "am")),
    Two(new Hour(2, "am")),
    Three(new Hour(3, "am")),
    Four(new Hour(4, "am"));

    private final Hour hour;

    WorkHours(Hour hour) {
        this.hour = hour;
    }
}
