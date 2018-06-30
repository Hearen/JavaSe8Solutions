package chap6_concurrency;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.System.out;
import static util.Output.readFileByWords;

public class Sol_1 {
    @Test
    public void testAtomicReference() {
        AtomicReference<String> theLongest = new AtomicReference<>("");
        List<String> words = readFileByWords();
        words.stream().parallel().forEach(word -> {
            out.println(Thread.currentThread().getName());
            theLongest.accumulateAndGet(word, (w1, w2) -> w1.length() > w2.length() ? w1 : w2);
        });
        out.println(theLongest.get());
    }
}
