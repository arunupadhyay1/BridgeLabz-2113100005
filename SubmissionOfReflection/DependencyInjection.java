import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    public void serve() {
        System.out.println("Service is serving...");
    }
}

class Client {
    @Inject
    private Service service;

    public void doSomething() {
        service.serve();
    }
}

public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        for (Field field : Client.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(client, new Service());
            }
        }
        client.doSomething();
    }
}