import java.util.*;
public class simpleinterest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
	System.out.println("Enter principal");
	float p = sc.nextFloat();
	System.out.println("Enter rate");
	float r = sc.nextFloat();
	System.out.println("Enter time");
	float t = sc.nextFloat();
	float si =((p*r*t)/100);
	System.out.println("Simple Interest is " + si);
}
}