import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubarraysExample {
    public static void main(String[] args) {
        ZeroSumSubarrays zsa = new ZeroSumSubarrays();
        int[] arr = {1, -1, 2, -2, 3, -3, 0};
        List<List<Integer>> result = zsa.findSubarrays(arr);
        for (List<Integer> subarray : result) {
            System.out.println(subarray);
        }
    }
}
class ZeroSumSubarrays {
    public List<List<Integer>> findSubarrays(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = start + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }
}
