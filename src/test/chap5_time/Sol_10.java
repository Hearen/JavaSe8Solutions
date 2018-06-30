package chap5_time;

import org.junit.Test;

import java.time.*;

import static java.lang.System.out;

public class Sol_10 {
    @Test
    public void testTravel() {
        out.println(getTravelEndTime("America/Los_Angeles",
                LocalDateTime.of(2018, 6, 30, 15, 5),
                Duration.ofSeconds((10 * 60 + 50) * 60).getSeconds(), "Europe/Paris"));
    }

    public LocalDateTime getTravelEndTime(String startZoneId, LocalDateTime localDateTime, long travelTimeSeconds, String endZoneId) {
        out.println(Instant.now().atZone(ZoneId.of(startZoneId)));
        out.println(Instant.now().atZone(ZoneId.of(endZoneId)));
        return localDateTime
                .atZone(ZoneId.of(startZoneId))
                .toInstant()
                .plusSeconds(travelTimeSeconds)
                .atZone(ZoneId.of(endZoneId))
                .toLocalDateTime();
    }
}
