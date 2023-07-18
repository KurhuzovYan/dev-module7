package global.goit;

import java.util.Scanner;

public class HttpImageStatusCli {

    void askStatus() {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        System.out.println("Enter HTTP status code:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Please enter valid number!");
            }
        }
        try {
            downloader.downloadStatusImage(Integer.parseInt(s));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("There is not image for HTTP status %s", s));
        }
    }
}
