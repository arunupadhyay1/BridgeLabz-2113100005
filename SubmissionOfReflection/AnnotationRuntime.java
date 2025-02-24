import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class MyClass {}

public class AnnotationRuntime {
    public static void main(String[] args) {
        Author author = MyClass.class.getAnnotation(Author.class);
        System.out.println("Author: " + author.name());
    }
}
