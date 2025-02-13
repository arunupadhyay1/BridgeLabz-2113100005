import java.util.LinkedList;
public class CustomHashMapExample {
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1)); // Output: 10
        System.out.println(map.get(2)); // Output: 20
        map.put(1, 15);
        System.out.println(map.get(1)); // Output: 15
        map.remove(2);
        System.out.println(map.get(2)); // Output: null
    }
}
class CustomHashMap {
    private static class HashNode {
        int key;
        int value;

        HashNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<HashNode>[] buckets;
    private int capacity;

    public CustomHashMap() {
        capacity = 16;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {
        int index = getBucketIndex(key);
        for (HashNode node : buckets[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        buckets[index].add(new HashNode(key, value));
    }

    public Integer get(int key) {
        int index = getBucketIndex(key);
        for (HashNode node : buckets[index]) {
            if (node.key == key) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = getBucketIndex(key);
        buckets[index].removeIf(node -> node.key == key);
    }
}

