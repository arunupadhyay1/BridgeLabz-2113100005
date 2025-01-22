import java.util.Scanner;

public class travel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter the city you are traveling from: ");
        String fromCity = scanner.nextLine();
        
        System.out.print("Enter the city you are traveling via: ");
        String viaCity = scanner.nextLine();
        
        System.out.print("Enter the final destination city: ");
        String toCity = scanner.nextLine();
        
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double fromToVia = scanner.nextDouble();
        
        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " (in miles): ");
        double viaToFinalCity = scanner.nextDouble();
        
        System.out.print("Enter the time taken for the journey (in hours): ");
        double timeTaken = scanner.nextDouble();
        
        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;
        
        System.out.printf("Travel Itinerary for %s:\n", name);
        System.out.printf("From: %s, Via: %s, To: %s\n", fromCity, viaCity, toCity);
        System.out.printf("Total Distance: %.2f miles\n", totalDistance);
        System.out.printf("Average Speed: %.2f miles/hour\n", averageSpeed);
        
        scanner.close();
    }
}
