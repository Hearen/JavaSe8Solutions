package chap6_concurrency;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

import static java.lang.System.out;
import static util.Output.extractUrlsFromString;
import static util.Output.getUrlContentsAsString;

public class Sol_10 {
    public static void main(String... args) {
        CompletableFuture<List<String>> linksFuture = CompletableFuture.supplyAsync(() -> readUrlFromConsole())
                .thenCompose(url -> CompletableFuture.supplyAsync(() -> {
                    out.println(Thread.currentThread().getName());
                    return extractUrlsFromString(getUrlContentsAsString(url));
                }));
        out.println(linksFuture.join());
    }

    private static String readUrlFromConsole() {
        out.println(Thread.currentThread().getName());
        Scanner inputReader = new Scanner(System.in);
        out.println("please enter a url:");
        String input = inputReader.nextLine();
        return input;
    }
}
