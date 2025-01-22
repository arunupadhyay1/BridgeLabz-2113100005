import java.util.*;
public class kilotomile{
	public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
	System.out.println("Enter distance in kilometers");
	float k = sc.nextFloat();
	double m = (k * 0.621371);
	System.out.println("Distance in miles is "+ m);
	}
}