import java.util.Scanner;

public class removespecificchar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter character to remove: ");
        char charToRemove = scanner.next().charAt(0);
        scanner.close();

        String modifiedStr = removeCharacter(str, charToRemove);
        System.out.println("Modified String: " + modifiedStr);
    }

    public static String removeCharacter(String str, char charToRemove) {
        return str.replaceAll(String.valueOf(charToRemove), "");
    }
}

