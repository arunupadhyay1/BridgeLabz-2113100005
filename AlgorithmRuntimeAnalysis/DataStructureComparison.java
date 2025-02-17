import java.util.*;

public class DataStructureComparison {
    public static void main(String[] args) {
        int[] data = generateRandomArray(10000, 0, 20000); // Large dataset
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        for (int num : data) {
            hashSet.add(num);
            treeSet.add(num); 
        }

        int target = data[new Random().nextInt(data.length)]; // Pick a random value as target

        long startTime, endTime;

        // Array Search
        startTime = System.nanoTime();
        linearSearch(data, target);
        endTime = System.nanoTime();
        System.out.println("Array Search Time: " + (endTime - startTime) + " ns");

        // HashSet Search
        startTime = System.nanoTime();
        hashSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) + " ns");

        // TreeSet Search
        startTime = System.nanoTime();
        treeSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) + " ns");
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
}
