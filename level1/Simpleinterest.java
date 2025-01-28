import java.util.Scanner;

public class Simpleinterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter Principal: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter Rate of Interest: ");
        double rate = scanner.nextDouble();
        System.out.print("Enter Time: ");
        double time = scanner.nextDouble();        
        double simpleInterest = calculatesimpleinterest(principal, rate, time);
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);       
        scanner.close();
    }    
    public static double calculatesimpleinterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}
