package chap9_java_7;

import org.junit.Test;
import util.ExceptionUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

public class Sol_11_grep {
    @Test
    public void testRecursiveGrep() {
        String curPath = Paths.get("").toAbsolutePath().toString();
//        recursiveGrepTo("\\s*@Test\\s*", curPath + "/src/test", curPath + "/src/test/chap9_java_7/filtered.txt");
        grepUsingProcessBuilder("@Test", curPath + "/src/test");
    }

    private void grepUsingProcessBuilder(String patternStr, String path) {
        ProcessBuilder processBuilder = new ProcessBuilder("/bin/grep", "-r", patternStr, path);
        try {
            Process process = processBuilder.start();
            process.waitFor();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedReader.lines().forEach(System.out::println);
        } catch(IOException | InterruptedException ignored) {
            ignored.printStackTrace();
        }
    }

    private void recursiveGrepTo(String patternStr, String rootPath, String outputPath) {
        Pattern pattern = Pattern.compile(patternStr);
        Map<String, List<String>> filteredFilMap = new HashMap<>();
        try (Stream<Path> paths = Files.walk(Paths.get(rootPath))) {
            // matched lines and its files;
            paths.filter(Files::isRegularFile)
                    .forEach(ExceptionUtil.exWrapper((Path path) -> {
                                Files.lines(path, StandardCharsets.UTF_8)
                                        .filter(s -> pattern.matcher(s).matches())
                                        .forEach(ExceptionUtil.exWrapper((String s) -> {
                                                    filteredFilMap.computeIfAbsent(path.toAbsolutePath().toString(),
                                                            k -> new ArrayList<>()).add(s);
                                                }
                                        ));
                            }));
            out.println(filteredFilMap);
            Files.write(Paths.get(outputPath), filteredFilMap.entrySet().stream()
                    .map(entry -> entry.getKey() + ":" + entry.getValue()).collect(toList()));
            // Only save all the matched lines without corresponding files;
//            List<String> filtered = paths.filter(path -> Files.isRegularFile(path))
//                    .flatMap(ExceptionUtil.exWrapper((Path path) -> Files.lines(path, StandardCharsets.UTF_8)))
//                    .filter(s -> pattern.matcher(s).matches())
//                    .collect(toList());
//            out.println(filtered);
//            Files.write(Paths.get(outputPath), filtered);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }
}
