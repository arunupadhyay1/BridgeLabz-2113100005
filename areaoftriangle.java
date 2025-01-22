import java.util.Scanner;
public class areaoftriangle{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the height of triangle in inches: ");
		double height=sc.nextDouble();
		System.out.print("Enter the height of triangle in inches: ");
		double base=sc.nextDouble();
	    System.out.println("The area of triangle in square inches is "+(height*base*0.5)+" and area in square cm  is "+ (height*base*0.5*6.4516));
	}
}