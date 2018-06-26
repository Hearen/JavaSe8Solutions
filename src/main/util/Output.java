package util;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import sun.misc.ClassLoaderUtil;

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

    public static List<String> readFile() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream is = loader.getResourceAsStream("file.txt");
        List<String> lines = new ArrayList<>();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {

        }
        return lines;
    }
}
