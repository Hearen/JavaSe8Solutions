package chap8_others;

import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsFirst;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class Sol_7 {
    @Test
    public void testNullsFirst() {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(null);
        // nullsFirst(naturalOrder().reversed());
        intList.stream().sorted(nullsFirst(comparing((Integer i) -> i.intValue(), reverseOrder()))).forEach(out::print);
        out.println();
        intList.stream().sorted(nullsFirst(comparing((Integer i) -> i.intValue()).reversed())).forEach(out::print);
        // will not work - lost the type info in come unknown way;
//        intList.stream().sorted(nullsFirst(naturalOrder().reversed())).forEach(out::print);
        out.println();
        intList.stream().sorted(nullsFirst(reverseOrder())).forEach(out::print);
        out.println();

        // different result: nullsFirst(naturalOrder()).reversed;
        intList.stream().sorted((a, b) -> {
            if (a == null) {
                return 1;
            } else return b.compareTo(a);
        }).forEach(out::print);
        out.println();
        intList.stream().sorted(nullsLast(reverseOrder())).forEach(out::print);
    }
}
