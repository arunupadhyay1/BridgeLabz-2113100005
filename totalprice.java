import java.util.Scanner;
public class totalprice{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the price of a single unit: ");
		int unitPrice=sc.nextInt();
		System.out.print("Enter the number of units: ");
		int quantity=sc.nextInt();
		
	    System.out.println("The totatl price of units are: "+(unitPrice*quantity));
	}
}