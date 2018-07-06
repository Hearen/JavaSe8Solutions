package chap8_others;

import static java.lang.System.out;
import static util.Output.readFileByWords;

import java.util.List;

import org.junit.Test;

public class Sol_5 {
    @Test
    public void testRemoveIf() {
        List<String> words = readFileByWords();
        out.println("The original size: " + words.size());
        words.removeIf(w -> w.length() <= 12);
        out.println("Small words removed: " + words.size());
    }
}
