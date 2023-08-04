import java.time.LocalTime;

public class Hour {
    private LocalTime startTime;
    private LocalTime endTime;

    public Hour(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private boolean isBeforeOrEqual(LocalTime time1, LocalTime time2) {
        return time1.equals(time2) || time1.isBefore(time2);
    }

    private boolean isAfterOrEqual(LocalTime time1, LocalTime time2) {
        return time1.equals(time2) || time1.isAfter(time2);
    }

    public boolean isTimeOn(LocalTime time) {
        return isBeforeOrEqual(time, this.endTime) && isAfterOrEqual(time, this.startTime);
    }
}
