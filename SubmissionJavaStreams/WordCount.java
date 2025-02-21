import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("reader.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        wordCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}