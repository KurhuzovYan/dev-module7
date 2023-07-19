package global.goit;

import java.util.Scanner;

public class HttpImageStatusCli {

    void askStatus() {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        while (true) {
            System.out.println("Enter HTTP status code:");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            if (!s.matches("\\d+")) {
                System.out.println("Please enter a valid number!");
                continue;
            }
            try {
                downloader.downloadStatusImage(Integer.parseInt(s));
                break;
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("There is not image for HTTP status %s", s));
            }
        }
    }
}
