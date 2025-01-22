import java.util.Scanner;
public class maxhandshake{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int numberOfStudents=sc.nextInt();
	    System.out.println("The maximum possible number of handshakes are "+(numberOfStudents*(numberOfStudents-1))/2);
	}
}