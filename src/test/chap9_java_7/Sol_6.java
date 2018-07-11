package chap9_java_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Sol_6 {
    @Test
    public void testFileLines() {
        String pwd = Paths.get("").toAbsolutePath().toString() + "/src/test/chap9_java_7/Sol_1.java";
        String outputDir = Paths.get(pwd).getParent().toString() + "/reversed_lines.txt";
        try {
            List<String> lines= Files.readAllLines(Paths.get(pwd));
            Collections.reverse(lines);
            Files.write(Paths.get(outputDir), lines);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }
}
