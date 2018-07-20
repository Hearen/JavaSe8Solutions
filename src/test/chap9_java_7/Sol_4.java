package chap9_java_7;

import static java.lang.System.out;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import org.junit.Test;

public class Sol_4 {
    private static void test() {
        out.println("I am b tester");
    }

    @Test
    public void testParentEx() {
        try {
            Method testMetohd = Sol_4.class.getDeclaredMethod("test");
            testMetohd.setAccessible(true);
            testMetohd.invoke(null);
//            Sol_4.class.getMethod("test").invoke(null);
        } catch (ReflectiveOperationException ignored) {
            ignored.printStackTrace();
        }
    }

    @Test
    public void testSeveralExs() {
        try {
            Method testMetohd = Sol_4.class.getDeclaredMethod("test");
            testMetohd.setAccessible(true);
            testMetohd.invoke(null);
//            Sol_4.class.getMethod("test").invoke(null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
            ignored.printStackTrace();
        }
    }
}
