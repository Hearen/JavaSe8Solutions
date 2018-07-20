package chap8_others;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

public class Sol_15_asPredicate {
    @Test
    public void testGrep() {
        out.println(Paths.get(".").toAbsolutePath().toString());
        grep("/Users/lhearen/programs/JavaSe8Solutions/src/test/chap8_others/Sol_15_asPredicate.java", "\\a+").forEach(out::println);
    }

    private List<String> grep(String filePath, String regx) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            return lines.filter(Pattern.compile(regx).asPredicate()).collect(toList());
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
        return new ArrayList<>();
    }
}
