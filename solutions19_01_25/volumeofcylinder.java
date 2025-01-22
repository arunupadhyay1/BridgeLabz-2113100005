import java.util.*;
public class volumeofcylinder{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius of cylinder");
		double r = sc.nextDouble();
		System.out.println("Enter height of cylinder");
		double h = sc.nextDouble();
		double v =(r*r * h*3.14);
		System.out.println("Volume of cylinder is " + v );
	}
}
