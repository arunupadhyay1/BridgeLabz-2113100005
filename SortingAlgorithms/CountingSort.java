import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] ages) {
        int maxAge = 18;
        int[] count = new int[maxAge + 1];
        for (int age : ages) {
            count[age]++;
        }
        int index = 0;
        for (int i = 0; i <= maxAge; i++) {
            while (count[i] > 0) {
                ages[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 14, 18, 17, 16, 15};
        countingSort(studentAges);
        System.out.println(Arrays.toString(studentAges));
    }
}