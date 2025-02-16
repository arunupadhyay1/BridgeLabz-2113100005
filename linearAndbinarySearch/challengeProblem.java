import java.io.*;

public class challengeProblem {
    public static void compareStringBuilderAndStringBuffer() {
        StringBuilder sb = new StringBuilder();
        StringBuffer sBuffer = new StringBuffer();
        long startTime, endTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sBuffer.append("hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime));
    }

    public static void readLargeFileAndCountWords(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int wordCount = 0;
        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        br.close();
        System.out.println("Word count: " + wordCount);
    }

    public static void main(String[] args) throws IOException {
        compareStringBuilderAndStringBuffer();
        readLargeFileAndCountWords("reader.txt");
    }
}