import java.io.*;

public class fileReader {
    public static void readFileLineByLine(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        readFileLineByLine("reader.txt");
    }
}