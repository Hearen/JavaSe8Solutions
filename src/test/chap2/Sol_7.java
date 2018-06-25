package test.chap2;

import org.junit.Test;

import java.util.Random;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;

public class Sol_7 {
    @Test
    public void testStreamFinity() {
        assertFalse(isStreamFinite(generateLong()));
    }

    private <T> boolean isStreamFinite(Stream<T> stream) {
        if (stream.count() < Long.MAX_VALUE) {
            return true;
        }
        return false;
    }

    private Stream<Long> generateLong() {
        return LongStream.generate(() -> new Random().nextLong()).boxed();
    }
}
