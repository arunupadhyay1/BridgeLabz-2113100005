import java.io.*;

public class wordOccurance {
    public static int countWordOccurrences(String filePath, String targetWord) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int count = 0;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equals(targetWord)) {
                    count++;
                }
            }
        }
        br.close();
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(countWordOccurrences("reader.txt", "suns"));
    }
}