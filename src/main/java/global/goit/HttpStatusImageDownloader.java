package global.goit;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpStatusImageDownloader {

    void downloadStatusImage(int code) {
        try {
            URL url = new URL(new HttpStatusChecker().getStatusImage(code));
            InputStream inputStream = url.openStream();
            new File("images").mkdir();
            OutputStream outputStream = new FileOutputStream(String.format("images/status-%s.jpg", code));
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error = ", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
