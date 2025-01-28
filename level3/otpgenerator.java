import java.util.HashSet;
import java.util.Set;

public class otpgenerator {

    public static void main(String[] args) {
        int[] otps = new int[10];
        
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }
        
        boolean areUnique = areOTPUnique(otps);
        
        System.out.println("Generated OTPs:");
        for (int otp : otps) {
            System.out.println(otp);
        }
        
        if (areUnique) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("There are duplicate OTPs.");
        }
    }

    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    public static boolean areOTPUnique(int[] otps) {
        Set<Integer> otpSet = new HashSet<>();
        for (int otp : otps) {
            if (!otpSet.add(otp)) {
                return false;
            }
        }
        return true;
    }
}
