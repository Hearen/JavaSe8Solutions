package util;

import java.util.function.Predicate;

public class ExceptionUtil {
    // https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

    public static <T> Predicate<T> exWrapper(PredicateWithEx<T> predicateWithEx) {
        return (T t) -> {
            boolean ret = true;
            try {
                ret = predicateWithEx.test(t);
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
            return ret;
        };
    }

    @FunctionalInterface
    public interface PredicateWithEx<T> {
        boolean test(T t) throws Exception;
    }
}
