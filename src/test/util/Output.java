package util;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Output {
    private Output() {
    }

    public static void printFilepaths(List<File> files, String msg) {
        files.stream()
                .map(File::getPath)
                .forEach(out::println);
        out.println(msg);
    }


    public static List<String> readWords(String filePath) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
            return Arrays.asList(contents.split("[\\P{L}]+"));
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
        return new ArrayList<>();
    }
}
