import java.util.HashMap;
public class PairWithGivenSumExample {
    public static void main(String[] args) {
        PairWithGivenSum pgs = new PairWithGivenSum();
        int[] arr = {10, 15, 3, 7};
        int target = 17;
        System.out.println(pgs.hasPairWithSum(arr, target)); // Output: true
    }
}
class PairWithGivenSum {
    public boolean hasPairWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(target - num)) {
                return true;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}

