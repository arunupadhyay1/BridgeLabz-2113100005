import java.util.HashMap;
import java.util.Scanner;

public class mostfrequentcharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

        char mostFrequentChar = findMostFrequentCharacter(str);
        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
    }

    public static char findMostFrequentCharacter(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        int maxCount = 0;
        char mostFrequentChar = ' ';

        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            if (charCount.get(ch) > maxCount) {
                maxCount = charCount.get(ch);
                mostFrequentChar = ch;
            }
        }
        return mostFrequentChar;
    }
}

