import java.util.*;
public class areaofcircle{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius");
		float r = sc.nextFloat();
		System.out.println("Area of circle is " + (  r*r * 22/7 ));	
	}
}