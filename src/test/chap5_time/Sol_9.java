package chap5_time;

import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.lang.System.out;

public class Sol_9 {
    @Test
    public void testZonedTime() {
        Instant now = Instant.now();
        ZoneId.getAvailableZoneIds().stream().forEach(zoneId -> {
            ZonedDateTime zonedDateTime = now.atZone(ZoneId.of(zoneId));
            if (zonedDateTime.getOffset().getTotalSeconds() % 3600 == 0) {
                out.println(zoneId + ": " + zonedDateTime);
            } else {
                out.println(zoneId);
            }
        });
    }
}
