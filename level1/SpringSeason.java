	public class SpringSeason {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide month and day as command line arguments.");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }

    public static boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20) {
            return true; // March 20 and onwards
        } else if (month == 4) {
            return true; // All of April
        } else if (month == 5) {
            return true; // All of May
        } else if (month == 6 && day <= 20) {
            return true; // Up to June 20
        }
        return false; // Not in Spring season
    }
}
