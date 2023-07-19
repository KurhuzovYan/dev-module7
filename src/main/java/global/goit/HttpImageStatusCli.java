package global.goit;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class HttpImageStatusCli {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpImageStatusCli.class);

    void askStatus() {
        BasicConfigurator.configure();
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        while (true) {
            LOGGER.info("Enter HTTP status code:");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            if (!s.matches("\\d+")) {
                LOGGER.info("Please enter a valid number!");
                continue;
            }
            try {
                downloader.downloadStatusImage(Integer.parseInt(s));
            } catch (Exception e) {
                LOGGER.error(String.format("There is not image for HTTP status %s", s));
            }
        }
    }
}
