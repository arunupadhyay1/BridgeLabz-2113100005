public class FibonacciComparison {
    public static void main(String[] args) {
        int n = 50;

        long startTime, endTime;

        // Recursive Fibonacci
        startTime = System.nanoTime();
        fibonacciRecursive(n);
        endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci Time: " + (endTime - startTime) + " ns");

        // Iterative Fibonacci
        startTime = System.nanoTime();
        fibonacciIterative(n);
        endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci Time: " + (endTime - startTime) + " ns");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}