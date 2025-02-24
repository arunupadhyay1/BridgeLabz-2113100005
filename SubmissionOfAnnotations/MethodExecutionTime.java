import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class Performance {
    @LogExecutionTime
    void executeTask() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MethodExecutionTime {
    public static void main(String[] args) throws Exception {
        Performance performance = new Performance();
        Method method = performance.getClass().getMethod("executeTask");
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();
            method.invoke(performance);
            long endTime = System.nanoTime();
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
        }
    }
}