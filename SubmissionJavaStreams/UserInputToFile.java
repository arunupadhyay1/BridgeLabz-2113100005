import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("userInfo.txt")) {
            System.out.print("Enter your name: ");
            String name = br.readLine();
            System.out.print("Enter your age: ");
            String age = br.readLine();
            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();
            fw.write("Name: " + name + "\nAge: " + age + "\nLanguage: " + language);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}