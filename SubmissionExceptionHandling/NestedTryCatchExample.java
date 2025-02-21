import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.print("Enter index: ");
        int index = scanner.nextInt();
        System.out.print("Enter divisor: ");
		int divisor = scanner.nextInt();
        try {
            try {
                System.out.println("Value at index " + index + ": " + array[index]);
                int result = array[index] / divisor;
                System.out.println("Result of division: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            scanner.close();
        }
    }
}