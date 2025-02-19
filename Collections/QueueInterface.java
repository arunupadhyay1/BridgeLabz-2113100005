import java.util.*;

class QueueInterface {
    public static void main(String[] args) {
        reverseQueue();
        generateBinaryNumbers();
        hospitalTriageSystem();
        implementStackUsingQueues();
        circularBufferSimulation();
    }

    public static void reverseQueue() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        System.out.println(queue);
    }

    public static void generateBinaryNumbers() {
        int N = 5;
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        queue.add("1");
        for (int i = 0; i < N; i++) {
            String binary = queue.remove();
            result.add(binary);
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
        System.out.println(result);
    }

    public static void hospitalTriageSystem() {
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt(Patient::getSeverity).reversed());
     queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));
        while (!queue.isEmpty()) {
            System.out.println(queue.remove().getName());
        }
    }

    public static void implementStackUsingQueues() {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        push(queue1, 1);
        push(queue1, 2);
        push(queue1, 3);
        System.out.println(pop(queue1, queue2)); // Output: 3
    }

    public static void push(Queue<Integer> queue, int x) {
        queue.add(x);
    }

    public static int pop(Queue<Integer> queue1, Queue<Integer> queue2) {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int top = queue1.remove();
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
        return top;
    }

    public static void circularBufferSimulation() {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);
        buffer.display(); // Output: [2, 3, 4]
    }
}

class Patient {
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }
}

class CircularBuffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity;
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity] + " ");
        }
        System.out.println();
    }
}