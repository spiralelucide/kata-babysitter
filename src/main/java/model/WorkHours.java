package model;

public enum WorkHours {
    Five(new Hour(5)),
    Six(new Hour(6)),
    Seven(new Hour(7)),
    Eight(new Hour(8)),
    Nine(new Hour(9)),
    Ten(new Hour(10)),
    Eleven(new Hour(11)),
    Twelve(new Hour(12)),
    One(new Hour(1)),
    Two(new Hour(2)),
    Three(new Hour(3)),
    Four(new Hour(4));

    private final Hour hour;

    WorkHours(Hour hour) {
        this.hour = hour;
    }

    public Hour getHour() {
        return hour;
    }
}
