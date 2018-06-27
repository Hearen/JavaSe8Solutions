package chap3;

import static java.lang.System.out;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

public class Sol_1 {

    @Test
    public void testDelayEvaluation() {
        int level = 1;
        testLog(level, () -> 1 == level, () -> "level: " + level);
        int newLevel = 2;
        testLog(newLevel, () -> 1 == newLevel, () -> "level: " + newLevel);
    }

    private void testLog(int level, Supplier... suppliers) {
        if (level > 1) {
            for (Supplier supplier : suppliers) {
                out.println(supplier.get());
            }
        }
    }
}
