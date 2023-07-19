package global.goit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpStatusChecker.class);

    public String getStatusImage(int code) {
        try {
            URL url = new URL(String.format("https://http.cat/%s.jpg", code));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 404) {
                LOGGER.error("Error 404! Please enter correct status code:");
            }
        } catch (IOException e) {
            LOGGER.error("Error = ", e);
        }
        return String.format("https://http.cat/%s.jpg", code);
    }
}