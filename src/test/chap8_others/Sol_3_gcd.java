package chap8_others;

import static java.lang.System.out;
import static util.Measure.getRunningTime;

import java.math.BigInteger;

import org.junit.Test;

public class Sol_3_gcd {
    @Test
    public void testGcd() {
        int a = Integer.MIN_VALUE;
        int b = 6;
        int testCount = 1_000_000;
        out.println(gcdBasic(a, b));
        out.println(gcdBigInteger(a, b));
        out.println(gcdFloorMod(a, b));
        getRunningTime(() -> { gcdBasic(a, b); }, testCount, "Basic");
        getRunningTime(() -> { gcdBigInteger(a, b); }, testCount, "BigInteger");
        getRunningTime(() -> { gcdFloorMod(a, b); }, testCount, "floorMod");
    }

    private int gcdBasic(int a, int b) {
        return a == 0? b : gcdBasic(b % a, a);
    }

    private int gcdBigInteger(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    private int gcdFloorMod(int a, int b) {
        return a == 0 ? b : gcdFloorMod(Math.floorMod(b, a), a);
    }

    private int gcdWithRem() {
        return 0;
    }

    private int rem(int a, int b) {
        return a % b; // what is an effective method?
    }
}
