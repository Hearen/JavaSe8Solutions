package util;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public final class Output {
    private Output() {
    }

    public static void printFilepaths(List<File> files, String msg) {
        files.stream()
                .map(File::getPath)
                .forEach(out::println);
        out.println(msg);
    }

    public static List<String> readWordsFromFilePath(String filePath) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
            return Arrays.asList(contents.split("[\\P{L}]+"));
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<String> readFileByWords() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(loader.getResource("file.txt").toURI())), StandardCharsets.UTF_8);
            return Arrays.asList(content.split("[\\P{L}]+"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
//        InputStream is = loader.getResourceAsStream("file.txt");
//        List<String> lines = new ArrayList<>();
//        try (BufferedReader br
//                     = new BufferedReader(new InputStreamReader(is))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                lines.add(line);
//            }
//        } catch (IOException e) {
//
//        }
//        return lines;
    }

    public static ArrayList<String> extractUrlsFromString(String content) {
        ArrayList<String> result = new ArrayList<>();

        String regex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        while (m.find()) {
            result.add(m.group());
        }

        return result;
    }

    public static String getUrlContentsAsString(String urlAsString) {
        try {
            URL url = new URL(urlAsString);
            String result = IOUtils.toString(url, StandardCharsets.UTF_8);
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
