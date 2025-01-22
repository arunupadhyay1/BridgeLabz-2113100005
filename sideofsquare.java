import java.util.Scanner;
public class sideofsquare{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the perimeter of square: ");
		double perimeter=sc.nextInt();
	    System.out.println("The side of square is "+(perimeter/4.0)+" whose perimeter is "+ perimeter);
	}
}