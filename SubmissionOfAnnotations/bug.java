import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "Null pointer exception")
    @BugReport(description = "Array index out of bounds")
    void process() {
        System.out.println("Processing...");
    }
}

public class bug {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("process");
        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
        for (BugReport report : bugReports) {
            System.out.println("Bug Report: " + report.description());
        }
    }
}