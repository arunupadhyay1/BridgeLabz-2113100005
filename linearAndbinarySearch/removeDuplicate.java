import java.util.Scanner;
import java.util.*;
public class removeDuplicate{
    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String to remove duplicates");
		String userInput = sc.nextLine();
        System.out.println(removeDuplicates(userInput));
    }
}