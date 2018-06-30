package chap6_concurrency;

import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.System.out;
import static util.Output.readWordsFromFilePath;

public class Sol_5 {
    @Test
    public void testConcurrentHashMap() {
        File folder = new File("/Users/lhearen/programs/JavaSe8Solutions/src/test/chap1");
        Map<String, Set<File>> wordFileMap = new ConcurrentHashMap<>();
        Arrays.stream(folder.listFiles()).parallel().forEach(file -> {
            out.println(file.getPath());
            out.println(Thread.currentThread().getName());
            List<String> words = readWordsFromFilePath(file.getPath());
            words.stream().forEach(word -> wordFileMap.merge(word, new HashSet<>(), (oldSet, newSet) -> {
                newSet.addAll(oldSet);
                return newSet;
            }).add(file));
        });
        wordFileMap.entrySet().forEach(entry -> {
            out.println("\"" + entry.getKey() + "\" in " + entry.getValue().size() + " file(s)");
        });
    }
}
