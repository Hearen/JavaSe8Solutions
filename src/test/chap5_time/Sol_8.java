package chap5_time;

import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.lang.System.out;

public class Sol_8 {
    @Test
    public void testZonedDate() {
        Instant now = Instant.now();
        ZoneId.getAvailableZoneIds().stream().forEach(zoneId -> {
            ZonedDateTime zonedDateTime = now.atZone(ZoneId.of(zoneId));
            out.println(zoneId + ": " + zonedDateTime.getOffset());
        });
    }
}
