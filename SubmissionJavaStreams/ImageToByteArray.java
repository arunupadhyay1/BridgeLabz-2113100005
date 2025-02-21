import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream("Gla.jpg")) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = baos.toByteArray();
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream("outputImage.jpg")) {
                fos.write(imageBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}