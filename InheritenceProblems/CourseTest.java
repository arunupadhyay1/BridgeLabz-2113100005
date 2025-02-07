public class CourseTest {
    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse();
        course.courseName = "Java Programming";
        course.duration = 30;
        course.platform = "Udemy";
        course.isRecorded = true;
        course.fee = 100.0;
        course.discount = 20.0;
        System.out.println("Course: " + course.courseName + ", Duration: " + course.duration + " days");
    }
}
class Course {
    String courseName;
    int duration;
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;
}


