/*Create a Student class to manage student data with the following features:
Static:
A static variable universityName shared across all students.
A static method displayTotalStudents() to show the number of students enrolled.
This:
Use this in the constructor to initialize name, rollNumber, and grade.
Final:
Use a final variable rollNumber for each student that cannot be changed.
Instanceof:
Check if a given object is an instance of the Student class before performing operations like displaying or updating grades.*/

public class Student{
	private static String universityName = "GLA University";
	private String studentName;
	private final String rollNumber;
	private String grade;
	private static int totalstudents = 0;
public Student(String studentName, String rollNumber, String grade){
	this.studentName = studentName;
	this.rollNumber = rollNumber;
	this.grade = grade;
	totalstudents++;
}
public static int displayTotalStudents(){
	return totalstudents;
}
public static void displayUniversityName(){
	System.out.println("University Name: "+ universityName);
} 
public void displayStudentdetails(){
	if (this instanceof Student){
		System.out.println("Student Name: "+ studentName);
		System.out.println("Student Roll number: "+ rollNumber);
		System.out.println("Student Grade: "+ grade);
	}
}
public static void main(String[] args){
	Student student1 = new Student("Arun","2113100005","B");
	Student student2 = new Student("Devansh","2113100007","A+");
	Student student3 = new Student("Shiv","2113100026","B+");
	Student student4 = new Student("Prakhar","2113100021","B+");
	Student student5 = new Student("Anubhav","2113100004","B");
	Student.displayUniversityName();
	student1.displayStudentdetails();
	student2.displayStudentdetails();
	student3.displayStudentdetails();
	student4.displayStudentdetails();
	student5.displayStudentdetails();
	System.out.println("Total Students: "+ Student.displayTotalStudents());
}
}