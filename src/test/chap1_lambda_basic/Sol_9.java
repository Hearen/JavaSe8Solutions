package chap1_lambda_basic;

import static java.lang.System.out;
import static util.Constants.NAMES;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Test;

public class Sol_9 {
    @Test
    public void testCollection2() {
        Collection2<String> names = new ArrayList2<>();
        names.addAll(NAMES);
        names.forEachIf(out::println, (t) -> t.length() > 5);
    }

    interface Collection2<T> extends Collection<T> {
        default void forEachIf(Consumer<T> action, Predicate<T> filter) {
            forEach((t) -> {
                if (filter.test(t)) {
                    action.accept(t);
                }
            });
        }
    }

    static class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {
    }
}
