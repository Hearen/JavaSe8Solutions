package chap9_java_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Extra_MoveFolder {
    public static void main(String... args) throws Exception {
        Path targetPath = Paths.get(Paths.get("").toAbsolutePath().toString().concat("/src/resources/").concat("a"));
        Path thePath = Paths.get(Paths.get("").toAbsolutePath().toString().concat("/src/resources/").concat("b"));
        moveFolder(thePath, targetPath);
    }

    private static void moveFolder(Path thePath, Path targetPath) {
        if (Files.exists(targetPath)) { // if the target folder exists, delete it first;
            deleteFolder(targetPath);
        }
        try {
            Files.move(thePath, targetPath);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }

    private static void deleteFolder(Path path) {
        try {
            if (Files.isRegularFile(path)) { // delete regular file directly;
                Files.delete(path);
                return;
            }
            try (Stream<Path> paths = Files.walk(path)) {
                paths.filter(p -> p.compareTo(path) != 0).forEach(p -> deleteFolder(p)); // delete all the children folders or files;
                Files.delete(path); // delete the folder itself;
            }
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }}
