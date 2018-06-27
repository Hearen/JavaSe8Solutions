package chap3;

import static java.lang.System.out;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class Sol_2 {
    @Test
    public void testMiddle() {
        ReentrantLock theLock = new ReentrantLock();
        withLock(theLock, () -> out.println("Am I within a lock?"));
    }

    private void withLock(ReentrantLock theLock, Runnable runnable) {
        theLock.lock();
        out.println("Locked");
        try {
            runnable.run();
        } finally {
            out.println("Finalizer");
            theLock.unlock();
            out.println("Unlocked");
        }
    }
}
