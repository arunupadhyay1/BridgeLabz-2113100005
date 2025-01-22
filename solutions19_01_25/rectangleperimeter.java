import java.util.*;
public class rectangleperimeter{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of rectangle");
		float l = sc.nextFloat();
		System.out.println("Enter width of rectangle");
		float w= sc.nextFloat();
		float p = 2 *(l + w);
		System.out.println("Perimeter of rectangle is " + p );
	}
}