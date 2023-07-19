package global.goit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        try {
            URL url = new URL(String.format("https://http.cat/%s.jpg", code));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 404) {
                throw new IllegalArgumentException("404");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.format("https://http.cat/%s.jpg", code);
    }
}