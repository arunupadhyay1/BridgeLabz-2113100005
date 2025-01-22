import java.util.Scanner;
public class distconverter{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter distance in feets");
		double feet =sc.nextDouble();
		double miles= (feet/5280) ;
		double yards= .33 * feet;
		System.out.println("The distance in miles is "+ miles +" and in yards is " + yards );
	}
}