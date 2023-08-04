import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OpeningHoursTest {

    @BeforeAll
    public static void initialSetup() {

        OpeningHours.addDay(DayOfWeek.MONDAY);
        OpeningHours.addDay(DayOfWeek.WEDNESDAY);
        OpeningHours.addDay(DayOfWeek.FRIDAY);

        OpeningHours.setHours(new Hour(LocalTime.of(8, 0), LocalTime.of(16, 0)));
    }

    @Test
    public void whenWednesday_thenShouldReturnTrue() {

        LocalDateTime wednesday = LocalDateTime.parse("2016-05-11T12:22:11.824");

        assertTrue(OpeningHours.isOpenOn(wednesday), "The shop should be open on Wednesday");
    }

    @Test
    public void whenThursday_thenShouldReturnFalse() {

        LocalDateTime thursday = LocalDateTime.parse("2016-05-12T12:22:11.824");

        assertFalse("The shop should be closed on Thursday", OpeningHours.isOpenOn(thursday));
    }

    @Test
    public void whenFridayMorning_thenShouldReturnTrue() {

        LocalDateTime fridayMorning = LocalDateTime.parse("2016-05-13T08:00:00.000");

        assertTrue(OpeningHours.isOpenOn(fridayMorning), "The shop should be open on Friday morning");
    }

    @Test
    public void whenWednesday_thenNextOpeningDate_shouldBeFriday() {
        LocalDateTime wednesday = LocalDateTime.parse("2016-05-11T12:22:11.824");
        DayOfWeek friday = DayOfWeek.FRIDAY;

        assertEquals("Next Opening day should be Friday when it's Wednesday", OpeningHours.nextOpeningDate(wednesday),
                friday);
    }
}
