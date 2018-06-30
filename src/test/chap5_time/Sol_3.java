package chap5_time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

import static java.lang.System.out;

public class Sol_3 {
    @Test
    public void testAdjuster() {
        LocalDate today = LocalDate.now();
        LocalDate nextWorkDay = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
        out.println(nextWorkDay);
        LocalDate nextSunday = today.with(next(w -> w.getDayOfWeek().getValue() == 7));
        out.println(nextSunday);
        LocalDate nextSaturday = today.with(next(w -> w.getDayOfWeek().getValue() == 6));
        out.println(nextSaturday);
    }

    private TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(w -> {
            LocalDate ret = w;
            do {
                ret = ret.plusDays(1);
            } while (!predicate.test(ret));
            return ret;
        });
    }
}
