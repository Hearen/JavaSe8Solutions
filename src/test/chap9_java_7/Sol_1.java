package chap9_java_7;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Test;

public class Sol_1 {
    @Test
    public void testInAndOut() {
        String pwd = Paths.get("").toAbsolutePath().toString() + "/src/test/chap9_java_7/Sol_1.java";
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get(pwd));
            out = new PrintWriter(Paths.get(pwd).getParent().toString() + "/test.txt");
            try {
                while (in.hasNext()) {
                    out.print(in.next());
                }
            } catch (IllegalStateException | NoSuchElementException readingEx) {
                readingEx.printStackTrace();
            }
        } catch (IOException inEx) {
            inEx.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
    }

    @Test
    public void usingTryWithResource() {
        String pwd = Paths.get("").toAbsolutePath().toString() + "/src/test/chap9_java_7/Sol_1.java";
        try (Scanner in = new Scanner(Paths.get(pwd));
                PrintWriter out=new PrintWriter(Paths.get(pwd).getParent().toString() + "/test.txt")){
            while (in.hasNext()) {
                out.print(in.next());
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
