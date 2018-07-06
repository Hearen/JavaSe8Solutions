package chap8_others;

import static java.lang.System.out;

import org.junit.Test;

public class Sol_2_exact {
    @Test(expected = ArithmeticException.class)
    public void testNegateExact() {
        Math.negateExact(Integer.MIN_VALUE);
    }

    @Test(expected = ArithmeticException.class)
    public void testMultiplyExact() {
        int a = 100_000;
        out.println(a * a);
        Math.multiplyExact(a, a);
    }
}
