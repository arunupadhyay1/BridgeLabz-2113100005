import java.io.*;

public class writeToFile {
    public static void readUserInputAndWriteToFile(String filePath) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        FileWriter fw = new FileWriter(filePath);
        String input;
        while (!(input = br.readLine()).equals("exit")) {
            fw.write(input + "\n");
        }
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        readUserInputAndWriteToFile("reader.txt");
    }
}
