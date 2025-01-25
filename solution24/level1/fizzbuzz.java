import java.util.Scanner;

public class fizzbuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        String[] results = new String[number + 1];

        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
				System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
				System.out.println("Fizz");
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
				System.out.println("Buzz");
            } else {
                results[i] = String.valueOf(i);
				System.out.println( i );
            }
        }
	}
}