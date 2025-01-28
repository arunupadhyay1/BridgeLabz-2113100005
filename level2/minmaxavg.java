import java.util.Random;

public class minmaxavg {

    public static void main(String[] args) {
        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);
        
        double[] results = findAverageMinMax(randomNumbers);
        System.out.printf("Average: %.2f\n", results[0]);
        System.out.printf("Minimum: %d\n", (int) results[1]);
        System.out.printf("Maximum: %d\n", (int) results[2]);
    }
    
    public static int[] generate4DigitRandomArray(int size) {
        Random random = new Random();
        int[] numbers = new int[size];
        
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + random.nextInt(9000); // Generates a 4-digit number
        }
        
        return numbers;
    }
    
    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        double average = sum / numbers.length;
        return new double[] { average, min, max };  // Removed non-breaking spaces here
    }
}