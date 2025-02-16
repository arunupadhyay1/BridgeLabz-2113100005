/*import java.util.*;

public class StringBuilderProblem1 {
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}*/
import java.util.Scanner;
import java.util.*;
 
 public class ReverseString{
	 public static String reverseString(String input){
		 StringBuilder sb = new StringBuilder(input);
		 return sb.reverse().toString();
	 }
	 
	 public static void main(String[] args){
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter a String to reverse");
		 String userInput = sc.nextLine();
		 System.out.println("Reversed String: " + reverseString(userInput));
		 sc.close();
	 }
 }
