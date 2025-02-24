import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

class Computation {
    private HashMap<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    int expensiveComputation(int input) {
        if (cache.containsKey(input)) {
            return cache.get(input);
        }
        // Simulating a time-consuming computation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = input * input; // Example computation
        cache.put(input, result);
        return result;
    }
}

public class CachingSystem {
    public static void main(String[] args) throws Exception {
        Computation computation = new Computation();
        Method method = computation.getClass().getMethod("expensiveComputation", int.class);

        long startTime = System.nanoTime();
        System.out.println("Result: " + computation.expensiveComputation(5));
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        System.out.println("Result: " + computation.expensiveComputation(5)); // Should use cache
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
    }
}