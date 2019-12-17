package book;

public class DateTime {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minutes;

    public DateTime() {
    }

    public DateTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public DateTime(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public DateTime(int year, int month, int day, int hour, int minutes) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public boolean isBigger(DateTime anotherDateTime){
        return this.year >= anotherDateTime.getYear() &&
                (this.month > anotherDateTime.getMonth() || (this.month == anotherDateTime.getMonth() && this.day >= anotherDateTime.getDay()));
    }

    @Override
    public String toString() {
        return year + " "  + month + " " + day + " " + hour + " " + minutes;
    }
}
