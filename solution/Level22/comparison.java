import java.util.Scanner;

public class comparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the age of Amar: ");
        int ageAmar = sc.nextInt();
        
        System.out.print("Enter the age of Akbar: ");
        int ageAkbar = sc.nextInt();
        
        System.out.print("Enter the age of Anthony: ");
        int ageAnthony = sc.nextInt();
        
        System.out.print("Enter the height of Amar (in cm): ");
        double heightAmar = sc.nextDouble();
        
        System.out.print("Enter the height of Akbar (in cm): ");
        double heightAkbar = sc.nextDouble();
        
        System.out.print("Enter the height of Anthony (in cm): ");
        double heightAnthony = sc.nextDouble();
        
        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        String youngestFriend = "";
        
        if (youngestAge == ageAmar) {
            youngestFriend = "Amar";
        } else if (youngestAge == ageAkbar) {
            youngestFriend = "Akbar";
        } else {
            youngestFriend = "Anthony";
        }
        
        double tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        String tallestFriend = "";
        
        if (tallestHeight == heightAmar) {
            tallestFriend = "Amar";
        } else if (tallestHeight == heightAkbar) {
            tallestFriend = "Akbar";
        } else {
            tallestFriend = "Anthony";
        }
        
        System.out.println("The youngest friend is: " + youngestFriend + " with age " + youngestAge);
        System.out.println("The tallest friend is: " + tallestFriend + " with height " + tallestHeight + " cm");
        
        sc.close();
    }
}