package chap9_java_7;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class Sol_7 {
    @Test
    public void testPageRead() {
        String pwd = Paths.get("").toAbsolutePath().toString() + "/src/test/chap9_java_7/Sol_1.java";
        String outputDir = Paths.get(pwd).getParent().toString() + "/test-1.txt";
        try {
            URL url = new URL("https://github.com/Hearen/JavaSe8Solutions");
            Files.copy(url.openStream(), Paths.get(outputDir), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }
}
