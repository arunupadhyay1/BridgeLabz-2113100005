import java.lang.reflect.Method;

class Example {
    public void exampleMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MethodExecutionTime {
    public static void main(String[] args) throws Exception {
        Example example = new Example();
        Method method = Example.class.getMethod("exampleMethod");
        
        long startTime = System.nanoTime();
        method.invoke(example);
        long endTime = System.nanoTime();
        
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
    }
}
