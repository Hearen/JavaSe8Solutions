package chap2;

import static java.lang.System.out;
import static util.Constants.FILE_PATH;
import static util.Output.readWords;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class Sol_2 {
    @Test
    public void testLimitInParallelStream() {
        AtomicInteger counter = new AtomicInteger(0);
        Long start = System.nanoTime();
        readWords(FILE_PATH).stream().parallel()
                // using parallel together with limit will badly impair the performance;
                // and also the thread will not be stopped directly after the last element found;
                // more details: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#limit-long-
                .filter(word -> {
//                    out.println(Thread.currentThread().getName() + ": " + word);
                    return word.length() > 12;
                })
                .limit(5)
                .forEachOrdered(word -> {
                    counter.getAndIncrement();
//                    out.println(word);
                });
        out.println(counter.get());
        out.println("Time costed by parallelStream: " + (System.nanoTime() - start));
    }

    @Test
    public void testLimitInSequentialStream() {
        AtomicInteger counter = new AtomicInteger(0);
        Long start = System.nanoTime();
        readWords(FILE_PATH).stream()
                .filter(word -> {
//                    out.println(word);
                    return word.length() > 12;
                })
                .limit(5)
                .forEachOrdered(word -> {
                    counter.getAndIncrement();
//                    out.println(word);
                });
        out.println(counter.get());
        out.println("Time costed by plain Stream: " + (System.nanoTime() - start));
    }
}
