import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        File sourceFile = new File("reader.txt");
        File destFile = new File("writer.txt.dat");
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile))) {
            long startTime = System.nanoTime();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();
            System.out.println("Buffered copy time: " + (endTime - startTime) + " ns");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}