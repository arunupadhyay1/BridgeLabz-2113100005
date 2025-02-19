import java.util.*;

public class ListInterface {
    public static void main(String[] args) {
        reverseArrayList();
        reverseLinkedList();
        findFrequency();
        rotateList();
        removeDuplicates();
        findNthElementFromEnd();
    }

    public static void reverseArrayList() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        System.out.println(reversed);
    }

    public static void reverseLinkedList() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> reversed = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        System.out.println(reversed);
    }

    public static void findFrequency() {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String s : list) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        System.out.println(frequencyMap);
    }

    public static void rotateList() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;
        Collections.rotate(list, -rotateBy);
        System.out.println(list);
    }

    public static void removeDuplicates() {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        System.out.println(new ArrayList<>(set));
    }

    public static void findNthElementFromEnd() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int N = 2;
        ListIterator<String> forward = list.listIterator();
        ListIterator<String> backward = list.listIterator();
        for (int i = 0; i < N; i++) {
            if (backward.hasNext()) backward.next();
        }
        while (backward.hasNext()) {
            forward.next();
            backward.next();
        }
        System.out.println(forward.previous());
    }
}