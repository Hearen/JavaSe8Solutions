package chap5_time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.lang.System.out;

public class Sol_5 {
    @Test
    public void testDaysGap() {
        LocalDate birthday = LocalDate.of(1992, 10, 4);
        out.println(birthday.until(LocalDate.now(), ChronoUnit.DAYS));

        LocalDate babeDay = LocalDate.of(2017, 9, 5);
        out.println(babeDay.until(LocalDate.now(), ChronoUnit.DAYS));

        LocalDate meetDay = LocalDate.of(2017, 9, 15);
        out.println(ChronoUnit.DAYS.between(meetDay, LocalDate.now()));
    }

}


