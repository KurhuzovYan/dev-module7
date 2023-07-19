package global.goit;

import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.*;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        BasicConfigurator.configure();
        try {
            URL url = new URL(String.format("https://http.cat/%s.jpg", code));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 404) {
                throw new IllegalArgumentException("Error 404! Please give correct status code!");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error = ", e);
        }
        return String.format("https://http.cat/%s.jpg", code);
    }
}
