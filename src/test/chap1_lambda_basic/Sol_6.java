package chap1_lambda_basic;

import static java.lang.System.out;

import org.junit.Test;

public class Sol_6 {
    private static Runnable uncheck(RunnalbeWithEx runnalbeWithEx) {
        return () -> {
            try {
                runnalbeWithEx.run();
            } catch (Exception ignored) {
            }
        };
    }

    @Test
    public void testExceptionWrapper() {
        new Thread(uncheck(() -> {
            out.println("Zzzzz...");
            Thread.sleep(1000);
        })).start();
    }

    @FunctionalInterface
    interface RunnalbeWithEx {
        void run() throws Exception;
    }
}
