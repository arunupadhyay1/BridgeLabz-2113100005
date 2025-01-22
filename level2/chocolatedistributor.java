import java.util.Scanner;

public class chocolatedistributor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        System.out.printf("The number of chocolates each child gets is %d and the number of remaining chocolates are %d%n", chocolatesPerChild, remainingChocolates);
        scanner.close();
    }
}
