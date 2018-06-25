package chap1;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Sol_1 {
    @Test
    public void testSort() {
        Integer[] arr = new Random().ints(5).boxed().toArray(Integer[]::new);
        CopyOnWriteArraySet<String> threadNames = new CopyOnWriteArraySet<>();
        threadNames.add(Thread.currentThread().getName());
        Arrays.sort(arr, (a, b) -> {
            threadNames.add(Thread.currentThread().getName());
            return Integer.valueOf(a).compareTo(b);
        });

        assertEquals(threadNames.size(), 1);
    }
}
