package chap5_time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.System.out;

public class Sol_6 {
    @Test
    public void testFridays() {
        listAllFridays(LocalDate.of(2000, 1, 1), LocalDate.now(), DayOfWeek.FRIDAY);
    }

    private void listAllFridays(LocalDate startDay, LocalDate endDay, DayOfWeek dayOfWeek) {
        LocalDate theDay = startDay;
//        while (!theDay.until(endDay).isZero()) {
//            if (theDay.getDayOfWeek() == dayOfWeek) {
//                out.println(theDay);
//            }
//            theDay = theDay.plusDays(1);
//        }

        while (theDay.isBefore(endDay)) {
            if (theDay.getDayOfWeek() == dayOfWeek) {
                out.println(theDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd E")));
            }
            theDay = theDay.plusDays(1);
        }
    }
}
