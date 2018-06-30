package chap5_time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static java.lang.System.out;

public class Sol_1 {
    @Test
    public void testCoderDay() {
        out.println(getCoderDayByPlus(2018));
        out.println(getCoderDayByPeriod(2018));
    }

    public LocalDate getCoderDayByPlus(int year) {
        return LocalDate.of(year, 1, 1).plusDays(255);
    }

    public LocalDate getCoderDayByPeriod(int year) {
        return LocalDate.of(year, 1, 1).plus(Period.ofDays(255));
    }
}
