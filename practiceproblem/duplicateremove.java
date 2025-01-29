import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class duplicateremove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        String result = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        Set<Character> seen = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (seen.add(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

