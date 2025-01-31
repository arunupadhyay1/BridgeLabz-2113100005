import java.util.*;
public class Employeedetails{
private static String name;
private static int id;
private static int salary;

public Employeedetails(String name,int id,int salary){
this.name=name;
this.id=id;
this.salary=salary;
}
public void DisplayEmployeeDetail(){
System.out.println("The employee details are: ");
System.out.println("The name of Employee is: "+ name);
System.out.println("The id of employee is: "+id);
System.out.println("The salary is : "+salary);

}
public static void main(String[] args){
Employeedetails employee1=new Employeedetails("Rahul",124,50000);
employee1.DisplayEmployeeDetail();

}


}