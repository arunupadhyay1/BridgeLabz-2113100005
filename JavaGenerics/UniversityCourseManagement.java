import java.util.ArrayList;
import java.util.List;

public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<CourseType> courseManagement = new Course<>();
        courseManagement.addCourse(new ExamCourse("Math Exam"));
        courseManagement.addCourse(new AssignmentCourse("Science Assignment"));
        courseManagement.addCourse(new ResearchCourse("History Research"));

        courseManagement.displayCourses(courseManagement.getCourses());
    }
}

abstract class CourseType {
    String title;
    public CourseType(String title) {
        this.title = title;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String title) {
        super(title);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title) {
        super(title);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title) {
        super(title);
    }
}

class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }

    public void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.title);
        }
    }
}
