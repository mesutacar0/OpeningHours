import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class OpeningHours {

    private static Set<DayOfWeek> days = new HashSet<>();
    private static Hour hours;

    public static void addDay(DayOfWeek day) {
        days.add(day);
    }

    public static void setHours(Hour hr) {
        hours = hr;
    }

    public static boolean isOpenOn(LocalDateTime dateTime) {
        DayOfWeek day = dateTime.getDayOfWeek();
        LocalTime time = dateTime.toLocalTime();
        return days.contains(day) && hours.isTimeOn(time);
    }

    public static DayOfWeek nextOpeningDate(LocalDateTime dateTime) {
        int dayIndex = dateTime.getDayOfWeek().getValue();

        return days.stream().filter(d -> d.getValue() > dayIndex).sorted().findFirst().orElseThrow();
    }

}
