import java.util.Scanner;
public class temperature{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter temperature in celcius");
		float c = sc.nextFloat();
		System.out.println("Temperature in Fahrenheit is "  +  ((c*9/5)+32) );
		
	}
}