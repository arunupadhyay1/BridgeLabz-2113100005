import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class ImportantTasks {
    @ImportantMethod(level = "HIGH")
    void criticalTask() {
        System.out.println("Critical task executed.");
    }

    @ImportantMethod
    void regularTask() {
        System.out.println("Regular task executed.");
    }
}

public class ImpMethods {
    public static void main(String[] args) throws Exception {
        Method[] methods = ImportantTasks.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }
}