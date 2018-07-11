import static java.lang.System.out;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class HelloWord {
    public static void main(String... args) {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("application.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void testCharCounting() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = scan.nextLine();
        String ret = str.chars().mapToObj(c -> (char) c).collect(groupingBy(c -> c, counting()))
                .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(joining(", "));
        System.out.println(ret);
    }


    private static String readUrlFromConsole() {
        Scanner inputReader = new Scanner(System.in);
        out.println("please enter a url:");
        String input = inputReader.nextLine();
        return input;
    }
}
