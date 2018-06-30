package chap6_concurrency;

import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.Stream;

import static java.lang.System.out;
import static util.Output.readFileByWords;

public class Sol_4 {
    @Test
    public void testLongAccumulator() {
        List<String> words = readFileByWords();
        LongAccumulator shortest = new LongAccumulator(Long::min, Long.MAX_VALUE);
        LongAccumulator longest = new LongAccumulator(Long::max, Long.MIN_VALUE);
        words.stream().parallel().forEach(word -> {
            shortest.accumulate(word.length());
            longest.accumulate(word.length());
        });
        out.println("Shortest Length: " + shortest.intValue());
        out.println("Longest Length: " + longest.intValue());

        LongAccumulator smallest = new LongAccumulator(Long::min, Long.MAX_VALUE);
        Stream<Integer> integerStream = Stream.generate(() -> new Random().nextInt(100) + 100).limit(1000);
        integerStream.parallel().forEach(i -> smallest.accumulate(i));
        out.println("Smallest Num: " + smallest.intValue());
    }
}
