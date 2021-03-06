package chap3_lambda;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;

public class Sol_22 {
    @Test
    public void testCompletableFutureFlatMap() {
        CompletableFuture<Integer> intFuture = CompletableFuture.supplyAsync(() -> 1)
                .thenCompose(a -> CompletableFuture.supplyAsync(() -> a + 1));
        // works as b map resulting in nested CompletableFuture;
//        intFuture.thenApply(b -> CompletableFuture.supplyAsync(() -> b + 1));
        assertEquals(intFuture.join().intValue(), 2);
    }
}
