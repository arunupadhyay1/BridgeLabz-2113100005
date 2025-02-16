/*public class StringBufferProblem1 {
    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!"};
        System.out.println(concatenateStrings(strings));
    }
}*/
import java.util.Scanner;
public class concatenateString{
	public static String concatenateStrings(String[] strings){
		StringBuffer sb = new StringBuffer();
		for(String str : strings){
			sb.append(str);
		}
		return sb.toString();
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Space-separated strings:");
		String[] strArray = scanner.nextLine().split(" ");
		//String[] strings = {"Arun", " ", "a", " ", "good", " ", "boy"};
		System.out.println(concatenateStrings(strArray));
		scanner.close();
	}
}