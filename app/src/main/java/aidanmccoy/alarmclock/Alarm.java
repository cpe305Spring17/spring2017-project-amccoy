package aidanmccoy.alarmclock;

/**
 * Created by aidanmccoy on 6/12/17.
 */

public class Alarm {
    private int hour;
    private int min;
    private int day;

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }
}
