import java.io.*;

public class binaryToCharacter {
    public static void convertByteStreamToCharacterStream(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        convertByteStreamToCharacterStream("reader.txt");
    }
}