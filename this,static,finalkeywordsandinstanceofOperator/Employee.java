/*Sample Program 3: Employee Management System
Design an Employee class with the following features:
Static:
A static variable companyName shared by all employees.
A static method displayTotalEmployees() to show the total number of employees.
This:
Use this to initialize name, id, and designation in the constructor.
Final:
Use a final variable id for the employee ID, which cannot be modified after assignment.
Instanceof:
Check if a given object is an instance of the Employee class before printing the employee details.*/

public class Employee{
	private static String companyName = "Capgemini Technology Services India Limited";
	private static int totalEmployees = 0;
	private final String id;
	private String name;
    private String designation;
public Employee(String id, String name, String designation){
	this.id = id;
	this.name = name;
	this.designation = designation;
	totalEmployees++;
 }
 public static void displaycompanyName(){
	 System.out.println("Company Name: "+ companyName);
 }
 public static int getTotalEmployees(){
	 return totalEmployees;
 }
 public void displayEmployeedetails(){
	 if (this instanceof Employee){
	 System.out.println("Employee Name: "+ name);
	 System.out.println("Employee id: "+ id);
	 System.out.println("Employee designation: "+ designation);
	 }
 }
 public static void main(String[] args){
	 Employee employee1 = new Employee("Mayank","01","GET");
	 Employee employee2 = new Employee("Arpit","02","GET");
	 Employee employee3 = new Employee("Arun","03","GET");
	 Employee employee4 = new Employee("Harsh","04","GET");
	 Employee employee5 = new Employee("Ojas","05","GET");
	 
	 Employee.displaycompanyName();
	 
	 employee1.displayEmployeedetails();
	 employee2.displayEmployeedetails();
	 employee3.displayEmployeedetails();
	 employee4.displayEmployeedetails();
	 employee5.displayEmployeedetails();
	 
	 System.out.println("Total Employees" + Employee.getTotalEmployees() );
 }
 }