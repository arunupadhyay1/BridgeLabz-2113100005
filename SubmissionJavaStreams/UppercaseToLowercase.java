import java.io.*;

public class UppercaseToLowercase {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("reader.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("writer.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}