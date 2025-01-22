import java.util.*;
public class power{  
   public static void main(String[] args){
	   Scanner sc = new Scanner(System.in);
   System.out.println("Enter base value");
   int b = sc.nextInt();
   System.out.println("Enter exponent value");
   int e = sc.nextInt();
   System.out.println("Result is " + (Math.pow(b,e)));
 }
}
