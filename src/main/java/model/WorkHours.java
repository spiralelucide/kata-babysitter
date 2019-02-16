package model;

public enum WorkHours {
    Five("5pm"),
    Six("6pm"),
    Seven("7pm"),
    Eight("8pm"),
    Nine("9pm"),
    Ten("10pm"),
    Eleven("11pm"),
    Twelve("12am"),
    One("1am"),
    Two("2am"),
    Three("3am"),
    Four("4am");

    private final String hour;

    WorkHours(String hour) {
        this.hour = hour;
    }

    public String getHour() {
        return hour;
    }
}
