import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) throws IOException {
        String filePath = "reader.txt"; // Path to a large file

        long startTime, endTime;

        // FileReader
        startTime = System.nanoTime();
        try (FileReader fr = new FileReader(filePath)) {
            int c;
            while ((c = fr.read()) != -1) {}
        }
        endTime = System.nanoTime();
        System.out.println("FileReader Time: " + (endTime - startTime) + " ns");

        // InputStreamReader
        startTime = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            int c;
            while ((c = isr.read()) != -1) {}
        }
        endTime = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endTime - startTime) + " ns");
    }
}
