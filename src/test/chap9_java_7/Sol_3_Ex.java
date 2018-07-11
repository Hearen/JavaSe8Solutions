package chap9_java_7;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Test;

public class Sol_3_Ex {
    @Test
    public void testInAndOut() throws IOException {
        throwEx(new Random().nextInt());
    }

    private void throwEx(int choice) throws IOException, IllegalStateException {
        if (choice < 1) {
            throw new NoSuchElementException("Test Element");
        } else {
            throw new IllegalStateException("Test State");
        }
    }
}
