package chap9_java_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class Sol_5 {
    @Test
    public void testFileReadWrite() {
        String pwd = Paths.get("").toAbsolutePath().toString() + "/src/test/chap9_java_7/Sol_1.java";
        String outputDir = Paths.get(pwd).getParent().toString() + "/reversed.txt";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(pwd));
            for (int i = 0, len = bytes.length / 2, size = bytes.length; i < len; ++i) {
                byte t = bytes[i];
                bytes[i] = bytes[size - i - 1];
                bytes[size - i - 1] = t;
            }
            Files.write(Paths.get(outputDir), bytes);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }
}
