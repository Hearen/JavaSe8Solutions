package chap8_others;

import static java.lang.System.out;
import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Sol_11_URL {
    public static void main(String... args) {
        try {
            URL url = new URL("the_url");
            URLConnection urlConnection = url.openConnection();
            String userName = "name";
            String pwd = "password";
            String userpass = userName + ":" + pwd;

            if (url.getUserInfo() != null) {
                String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
                urlConnection.setRequestProperty("Authorization", basicAuth);
            }
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream(), StandardCharsets.UTF_8))) {
                String s = bufferedReader.lines().collect(joining());
                out.println(s);
            }

        } catch (IOException ignored) {
            ignored.printStackTrace();
        }

    }
}
